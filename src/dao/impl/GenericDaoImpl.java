package dao.impl;

import dao.GenericDao;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DIALLO on 22/03/2017.
 */
//@Component
public class GenericDaoImpl<T,  PK extends Serializable>
        implements GenericDao<T, PK> {

    private static final Logger log = Logger
            .getLogger(GenericDaoImpl.class);
    @Autowired
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();;

    private Class<T> persistentClass;

    GenericDaoImpl(Class<T> persistantClass) {
        this.persistentClass = persistantClass;
    }

    @Override
    public PK save(T t) {
        log.debug("DAO : persisting " + t.getClass().getSimpleName() + " instance");
        final Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit();
        session.close();
        return (PK) t;
    }

    @Override
    public void saveOrUpdate(T o) throws DataAccessException {
        log.debug("DAO : attaching dirty " + o.getClass() + " instance");

        final Session session = this.sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();

        session.saveOrUpdate(o);
        tx.commit();
        session.close();

        log.debug("DAO : attach successful");

    }

    @Override
    public T read(PK id) throws Exception {
        log.debug("DAO : reading " + id + " instance");

        final Session session = sessionFactory.openSession();
        T t = session.get(persistentClass, id);
        session.close();
        if (t == null) {
            throw new Exception("No " + persistentClass + " found with id :  " + id);
        }
        return t;
    }

    @Override
    public T load(PK id) throws Exception {
        log.debug("DAO : Load " + id + " instance");

        final Session session = sessionFactory.openSession();
        return session.load(persistentClass, id);
    }

    @Override
    public T initialiseProxy(T transientObject) throws Exception {

        if (transientObject == null) {
            throw new Exception( persistentClass + " passed is null ");
        }
        log.debug("DAO : initialiseProxy " + transientObject.getClass().getSimpleName() + " instance");

        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();

        Hibernate.initialize(transientObject);
        if(transientObject instanceof HibernateProxy){
            transientObject = (T) ((HibernateProxy)transientObject).getHibernateLazyInitializer()
                    .getImplementation();
        }
        tx.commit();
        session.close();
        return transientObject;
    }

    @Override
    public void update(T t) {
        log.debug("DAO : updating " + t.getClass().getSimpleName() + " instance");

        final Session session = this.sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();

        session.update(t);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> list(){
        log.debug("DAO : reading all instances with Criteria");

        final Session session = this.sessionFactory.openSession();
        List<T> list = session.createCriteria(persistentClass).list();
        session.close();
        return list;
    }

    @Override
    public List<T> list(DetachedCriteria detachedCriteria) throws DataAccessException {
        log.debug("DAO : reading all instances with DetachedCriteria");

        final Session session = this.sessionFactory.openSession();
        final List<T> list = (List<T>) detachedCriteria.getExecutableCriteria(session).list();

        session.close();
        return list;
    }

    @Override
    public T getByProperty(String property, String value) throws DataAccessException {
        log.debug("DAO : getByProperty " + property + "  " + value);

        final Session session = this.sessionFactory.openSession();
        final T t = (T) session.createCriteria(this.persistentClass)
                .add(Restrictions.like(property, "%" + value + "%"))
                .uniqueResult();

        session.close();
        return t;
    }

    @Override
    public void delete(PK id){
        final Session session = sessionFactory.openSession();
        T t = session.get(persistentClass, id);
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(t);
        tx.commit();
        session.close();
    }

}
