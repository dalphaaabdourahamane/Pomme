package dao;

import entity.Ville;

import java.util.List;

/**
 * Created by dialal14 on 23/01/17.
 */
public interface VilleDao extends GenericDao<Ville, Long> {

    List<Ville> getByName(String nom) throws Exception;

    //NAME getall
    List<Ville> getAll();

    Ville readBureauVote(Ville ville);

    int getCollectionSize(Long pk);

    Long getCollectionSQLNativeSize(Long pk);

    Long getCollectionCriteariaSize(Long pk);

    Long getCollectionHQLSize(Long pk);
}
