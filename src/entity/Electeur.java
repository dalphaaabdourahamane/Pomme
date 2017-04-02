package entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dialal14 on 23/01/17.
 */
@Entity
@Table(name = "Electeur")
public class Electeur implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "EID")
    private Long eid;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @OneToOne(targetEntity = BureauVote.class,fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="bid", referencedColumnName="bid"),
            @JoinColumn(name="vid", referencedColumnName="vid")
    })
    private BureauVote bureauVote = new BureauVote();

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public BureauVote getBureauVote() {
        return bureauVote;
    }

    public void setBureauVote(BureauVote bureauVote) {
        this.bureauVote = bureauVote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electeur)) return false;

        Electeur electeur = (Electeur) o;

        if (getEid() != null ? !getEid().equals(electeur.getEid()) : electeur.getEid() != null) return false;
        if (getNom() != null ? !getNom().equals(electeur.getNom()) : electeur.getNom() != null) return false;
        if (getPrenom() != null ? !getPrenom().equals(electeur.getPrenom()) : electeur.getPrenom() != null)
            return false;
//        if (getVille() != null ? !getVille().equals(electeur.getVille()) : electeur.getVille() != null) return false;
        return getBureauVote() != null ? getBureauVote().equals(electeur.getBureauVote()) : electeur.getBureauVote() == null;
    }

    @Override
    public int hashCode() {
        int result = getEid() != null ? getEid().hashCode() : 0;
        result = 31 * result + (getNom() != null ? getNom().hashCode() : 0);
        result = 31 * result + (getPrenom() != null ? getPrenom().hashCode() : 0);
//        result = 31 * result + (getVille() != null ? getVille().hashCode() : 0);
        result = 31 * result + (getBureauVote() != null ? getBureauVote().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Electeur{" +
                "eid=" + eid +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", bureauVote=" + getBureauVote() +
                '}';
    }
    public String toString2() {
        return "Electeur{" +
                "eid=" + eid +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
