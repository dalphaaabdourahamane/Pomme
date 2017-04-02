package entity.utils;

import entity.BureauVote;
import entity.Ville;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by DIALLO on 23/03/2017.
 */
@StaticMetamodel(Ville.class)
public class Ville_ {
    public static volatile SingularAttribute<Ville,Long> VID;

}
