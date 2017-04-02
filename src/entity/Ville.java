package entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dialal14 on 23/01/17.
 */
@Entity
@Table(name = "VILLE")
public class Ville implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "VID")
    private Long vid;

    @Column(name = "NOM",length = 25)
    private String nom;

    @OneToMany(mappedBy = "keyBureauVote.ville", cascade = CascadeType.ALL,
//           fetch = FetchType.EAGER)
            orphanRemoval = true,fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
//    @LazyCollection(LazyCollectionOption.TRUE)
//    @OrderColumn
    private List<BureauVote> bureauVotes = new LinkedList<>();

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addBureauVote(BureauVote bureauVote) {
        bureauVotes.add( bureauVote );
        bureauVote.getKeyBureauVote().setVille( this );
    }

    public void removeBureauVote(BureauVote bureauVote) {
        bureauVotes.remove( bureauVote );
        bureauVote.getKeyBureauVote().setVille( null );
    }

    public List<BureauVote> getBureauVotes() {
        return bureauVotes;
    }

    public void setBureauVotes(List<BureauVote> bureauVotes) {
        this.bureauVotes = bureauVotes;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "vid=" + vid +
                ", nom='" + nom + '\'' +
                '}';
    }
    /*
    Affiche la ville avec les bureaux de votes
     */
    public String printWithBureauVote() {
        return "Ville{" +
                "VID=" + vid +
                ", nom='" + nom + '\'' +
                ", bureauVotes=" + bureauVotes +
                '}';
    }
}
