package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by barte on 16/11/2016.
 */
public class OdwiedzinyPK implements Serializable {
    private int idOdwiedzin;
    private int osobaIdStudenta;
    private int osobaIdPortiera;
    private int osobaIdGoscia;

    @Column(name = "IdOdwiedzin")
    @Id
    public int getIdOdwiedzin() {
        return idOdwiedzin;
    }

    public void setIdOdwiedzin(int idOdwiedzin) {
        this.idOdwiedzin = idOdwiedzin;
    }

    @Column(name = "Osoba_IdStudenta")
    @Id
    public int getOsobaIdStudenta() {
        return osobaIdStudenta;
    }

    public void setOsobaIdStudenta(int osobaIdStudenta) {
        this.osobaIdStudenta = osobaIdStudenta;
    }

    @Column(name = "Osoba_IdPortiera")
    @Id
    public int getOsobaIdPortiera() {
        return osobaIdPortiera;
    }

    public void setOsobaIdPortiera(int osobaIdPortiera) {
        this.osobaIdPortiera = osobaIdPortiera;
    }

    @Column(name = "Osoba_IdGoscia")
    @Id
    public int getOsobaIdGoscia() {
        return osobaIdGoscia;
    }

    public void setOsobaIdGoscia(int osobaIdGoscia) {
        this.osobaIdGoscia = osobaIdGoscia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdwiedzinyPK that = (OdwiedzinyPK) o;

        if (idOdwiedzin != that.idOdwiedzin) return false;
        if (osobaIdStudenta != that.osobaIdStudenta) return false;
        if (osobaIdPortiera != that.osobaIdPortiera) return false;
        if (osobaIdGoscia != that.osobaIdGoscia) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOdwiedzin;
        result = 31 * result + osobaIdStudenta;
        result = 31 * result + osobaIdPortiera;
        result = 31 * result + osobaIdGoscia;
        return result;
    }
}
