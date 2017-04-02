package entity.utils;

import entity.BureauVote;
import entity.Ville;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by DIALLO on 23/03/2017.
 */
@StaticMetamodel(KeyBureauVote.class)
public class KeyBureauVote_ {
    public static volatile SingularAttribute<KeyBureauVote,Long> BID;
    public static volatile SingularAttribute<KeyBureauVote, Ville> ville;
}
