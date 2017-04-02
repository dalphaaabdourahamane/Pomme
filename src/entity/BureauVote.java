package entity;

import entity.utils.KeyBureauVote;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dialal14 on 23/01/17.
 */
@Entity
@Table(name = "BUREAUVOTE")
public class BureauVote implements Serializable{

    @EmbeddedId
    private KeyBureauVote keyBureauVote;

    @Column(name = "NOM")
    private String nom;

    @Embedded
    private Adresse adresse = new Adresse();

    public KeyBureauVote getKeyBureauVote() {
        return keyBureauVote;
    }

    public void setKeyBureauVote(KeyBureauVote keyBureauVote) {
        this.keyBureauVote = keyBureauVote;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BureauVote)) return false;

        BureauVote that = (BureauVote) o;

        if (getKeyBureauVote() != null ? !getKeyBureauVote().equals(that.getKeyBureauVote()) : that.getKeyBureauVote() != null)
            return false;
        if (getNom() != null ? !getNom().equals(that.getNom()) : that.getNom() != null) return false;
        return getAdresse() != null ? getAdresse().equals(that.getAdresse()) : that.getAdresse() == null;
    }

    @Override
    public int hashCode() {
        int result = getKeyBureauVote() != null ? getKeyBureauVote().hashCode() : 0;
        result = 31 * result + (getNom() != null ? getNom().hashCode() : 0);
        result = 31 * result + (getAdresse() != null ? getAdresse().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BureauVote{" +
                "keyBureauVote=" + keyBureauVote +
                ", nom='" + nom + '\'' +
//                ", ville=" + ville +
                ", adresse=" + adresse +
                '}';
    }
}
