package dao.impl;

import dao.VilleDao;
import entity.BureauVote;
import entity.Ville;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * Created by dialal14 on 23/01/17.
 */
@Repository
public class VilleDaoImpl extends GenericDaoImpl<Ville, Long> implements VilleDao {

    public VilleDaoImpl() {
        super(Ville.class);
    }

    @Override
    public List<Ville> getByName(String nom) throws Exception {

        final Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Ville> villes = session.createQuery(" SELECT v FROM Ville  v WHERE v.nom LIKE :name",Ville.class)
                .setParameter("name","%" +nom+ "%")
                .getResultList();
        tx.commit();
        if (villes == null) {
            villes = Collections.emptyList();
        }
        return villes;
    }
    @Override
    //NAME getall
    public List<Ville> getAll(){

        final Session session = this.sessionFactory.openSession();
        List<Ville> list = session.createCriteria(Ville.class).setFetchMode("bureauVote", FetchMode.SELECT).list();
        session.close();
        return list;
    }
    @Override
    public List<Ville> list(){

        final Session session = this.sessionFactory.openSession();
        List<Ville> list = session.createQuery("from  Ville ",Ville.class).list();
        session.close();
        return list;
    }

    @Override
    public Ville readBureauVote(Ville ville){
        final Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ville = (Ville) session
                .createCriteria(Ville.class).setFetchMode("bureauVotes", FetchMode.JOIN)
                .add( Expression.eq("vid", ville.getVid()) )
                .uniqueResult(); // Eager fetch the colleciton so we can use it detached
        tx.commit();
        session.close();
        return  ville;
    }

    @Override
    public int getCollectionSize(Long pk){
        final Session session = this.sessionFactory.openSession();

        int count = 0;
        final Ville ville = session.get(Ville.class, pk);
        count = ville.getBureauVotes().size();
        session.close();
        return count;
    }

    @Override
    public Long getCollectionSQLNativeSize(Long pk){
        final Session session = this.sessionFactory.openSession();
        BigInteger count = (BigInteger) session
                .createNativeQuery("select count(BID)  from BUREAUVOTE  where VID = :vid")
                .setParameter("vid",pk).getSingleResult();
        session.close();
        return count.longValue();
    }

    @Override
    public Long getCollectionCriteariaSize(Long pk){
        final Session session = this.sessionFactory.openSession();
        final DetachedCriteria searchCriteria = DetachedCriteria.forClass(BureauVote.class);
        Long count = (Long)searchCriteria.add(Restrictions.eq("keyBureauVote.ville.vid",pk))
                .setProjection(Projections.rowCount())
                .getExecutableCriteria(session).uniqueResult();
        session.close();
        return count;
    }

    @Override
    public Long getCollectionHQLSize(Long pk){
        final Session session = this.sessionFactory.openSession();
        Long count = (Long) session.createQuery("SELECT count(*) FROM BureauVote bv " +
                "WHERE bv.keyBureauVote.ville.vid=:vid")
                .setParameter("vid",pk)
                .uniqueResult();
        session.close();
        return count;
    }
}