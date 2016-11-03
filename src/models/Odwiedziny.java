package models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by barte on 03/11/2016.
 */
@Entity
@IdClass(OdwiedzinyPK.class)
public class Odwiedziny {
    private int idOdwiedzin;
    private Date data;
    private int osobaIdStudenta;
    private int osobaIdPortiera;
    private int osobaIdGoscia;

    @Id
    @Column(name = "IdOdwiedzin")
    public int getIdOdwiedzin() {
        return idOdwiedzin;
    }

    public void setIdOdwiedzin(int idOdwiedzin) {
        this.idOdwiedzin = idOdwiedzin;
    }

    @Basic
    @Column(name = "Data")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Id
    @Column(name = "Osoba_IdStudenta")
    public int getOsobaIdStudenta() {
        return osobaIdStudenta;
    }

    public void setOsobaIdStudenta(int osobaIdStudenta) {
        this.osobaIdStudenta = osobaIdStudenta;
    }

    @Id
    @Column(name = "Osoba_IdPortiera")
    public int getOsobaIdPortiera() {
        return osobaIdPortiera;
    }

    public void setOsobaIdPortiera(int osobaIdPortiera) {
        this.osobaIdPortiera = osobaIdPortiera;
    }

    @Id
    @Column(name = "Osoba_IdGoscia")
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

        Odwiedziny that = (Odwiedziny) o;

        if (idOdwiedzin != that.idOdwiedzin) return false;
        if (osobaIdStudenta != that.osobaIdStudenta) return false;
        if (osobaIdPortiera != that.osobaIdPortiera) return false;
        if (osobaIdGoscia != that.osobaIdGoscia) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOdwiedzin;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + osobaIdStudenta;
        result = 31 * result + osobaIdPortiera;
        result = 31 * result + osobaIdGoscia;
        return result;
    }
}
