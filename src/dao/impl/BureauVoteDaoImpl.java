package dao.impl;

import dao.BureauVoteDao;
import entity.BureauVote;
import entity.utils.KeyBureauVote;
import org.springframework.stereotype.Repository;

/**
 * Created by dialal14 on 23/01/17.
 */
@Repository
public class BureauVoteDaoImpl extends GenericDaoImpl<BureauVote, KeyBureauVote> implements BureauVoteDao {

    public BureauVoteDaoImpl() {
        super(BureauVote.class);
    }
}
