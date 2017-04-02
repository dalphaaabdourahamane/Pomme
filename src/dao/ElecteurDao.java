package dao;

import entity.Electeur;

/**
 * Created by dialal14 on 23/01/17.
 */
public interface ElecteurDao  extends GenericDao<Electeur, Long>{

    Electeur readBureauVote(Electeur electeur);
}
