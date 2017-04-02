package entity.utils;

import entity.Ville;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by dialal14 on 24/01/17.
 * Represente la clé metier deu bureau de vote
 */
@Embeddable
public class KeyBureauVote implements Serializable {
    @Column(name = "BID")
    private Long BID;

    @ManyToOne
    @JoinColumn(name = "VID")
    private Ville ville = new Ville();

    public KeyBureauVote(Long BID, Ville ville) {
        this.BID = BID;
        this.ville = ville;
    }

    public KeyBureauVote(Long BID) {
        this.BID = BID;
    }

    public KeyBureauVote() {
    }

    public Long getBID() {
        return BID;
    }

    public void setBID(Long BID) {
        this.BID = BID;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyBureauVote)) return false;

        KeyBureauVote that = (KeyBureauVote) o;

        if (!getBID().equals(that.getBID())) return false;
        return getVille().equals(that.getVille());
    }

    @Override
    public int hashCode() {
        int result = getBID().hashCode();
        result = 31 * result + getVille().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "KeyBureauVote{" +
                "BID=" + BID +
                ", ville=" + ville +
                '}';
    }
}
