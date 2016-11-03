package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by barte on 03/11/2016.
 */
public class OplataPK implements Serializable {
    private int idOplaty;
    private int wniosekIdWniosku;

    @Column(name = "IdOplaty")
    @Id
    public int getIdOplaty() {
        return idOplaty;
    }

    public void setIdOplaty(int idOplaty) {
        this.idOplaty = idOplaty;
    }

    @Column(name = "Wniosek_IdWniosku")
    @Id
    public int getWniosekIdWniosku() {
        return wniosekIdWniosku;
    }

    public void setWniosekIdWniosku(int wniosekIdWniosku) {
        this.wniosekIdWniosku = wniosekIdWniosku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OplataPK oplataPK = (OplataPK) o;

        if (idOplaty != oplataPK.idOplaty) return false;
        if (wniosekIdWniosku != oplataPK.wniosekIdWniosku) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOplaty;
        result = 31 * result + wniosekIdWniosku;
        return result;
    }
}
