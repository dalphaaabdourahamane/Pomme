package dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import java.io.Serializable;
import java.util.List;
/**
 * Created by DIALLO on 21/03/2017.
 */
public interface GenericDao <T, PK extends Serializable> {

    T read(PK id) throws Exception;

    T load(PK id) throws Exception;

    T initialiseProxy(T transientObject) throws Exception;

    List<T> list() throws DataAccessException;

    List<T> list(DetachedCriteria detachedCriteria) throws DataAccessException;

    T getByProperty(String property, String value) throws DataAccessException;

    PK save(T newInstance) throws DataAccessException;

    void saveOrUpdate(T persistentObject) throws DataAccessException;

    void update(T transientObject) throws DataAccessException;

    void delete(PK id) throws DataAccessException;

}