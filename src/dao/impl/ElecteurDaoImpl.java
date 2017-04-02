package dao.impl;

import dao.ElecteurDao;
import entity.Electeur;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dialal14 on 23/01/17.
 */
@Repository
public class ElecteurDaoImpl extends GenericDaoImpl<Electeur, Long> implements ElecteurDao {

    public ElecteurDaoImpl() {
        super(Electeur.class);
    }

    @Override
    public Electeur readBureauVote(Electeur electeur){
        final Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        electeur = (Electeur) session
                .createCriteria(Electeur.class).setFetchMode("bureauVote", FetchMode.JOIN)
                .add( Expression.eq("eid", electeur.getEid()) )
                .uniqueResult(); // Eager fetch the colleciton so we can use it detached
        tx.commit();
        session.close();
        return  electeur;
    }
}