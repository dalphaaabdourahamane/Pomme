package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dialal14 on 23/01/17.
 */
@Embeddable
public class Adresse implements Serializable {

    @Column(name = "RUE")
    private String Rue;

    @Column(name = "CP")
    private Long cp;

    public String getRue() {
        return Rue;
    }

    public void setRue(String rue) {
        Rue = rue;
    }

    public Long getCp() {
        return cp;
    }

    public void setCp(Long cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adresse)) return false;

        Adresse adresse = (Adresse) o;

        if (getRue() != null ? !getRue().equals(adresse.getRue()) : adresse.getRue() != null) return false;
        return getCp() != null ? getCp().equals(adresse.getCp()) : adresse.getCp() == null;
    }

    @Override
    public int hashCode() {
        int result = getRue() != null ? getRue().hashCode() : 0;
        result = 31 * result + (getCp() != null ? getCp().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "Rue='" + Rue + '\'' +
                ", cp='" + cp + '\'' +
                '}';
    }
}
