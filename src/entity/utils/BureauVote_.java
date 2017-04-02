package entity.utils;

import entity.BureauVote;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by DIALLO on 23/03/2017.
 */
@StaticMetamodel(BureauVote.class)
public class BureauVote_ {
    public static volatile SingularAttribute<BureauVote,KeyBureauVote> keyBureauVote;
    public static volatile SingularAttribute<BureauVote,String> nom;
}
