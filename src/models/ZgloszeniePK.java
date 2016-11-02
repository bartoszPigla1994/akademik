package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by barte on 02/11/2016.
 */
public class ZgloszeniePK implements Serializable {
    private int idZgloszenia;
    private int pokojIdPokoju;
    private int osobaIdStudenta;

    @Column(name = "IdZgloszenia")
    @Id
    public int getIdZgloszenia() {
        return idZgloszenia;
    }

    public void setIdZgloszenia(int idZgloszenia) {
        this.idZgloszenia = idZgloszenia;
    }

    @Column(name = "Pokoj_IdPokoju")
    @Id
    public int getPokojIdPokoju() {
        return pokojIdPokoju;
    }

    public void setPokojIdPokoju(int pokojIdPokoju) {
        this.pokojIdPokoju = pokojIdPokoju;
    }

    @Column(name = "Osoba_IdStudenta")
    @Id
    public int getOsobaIdStudenta() {
        return osobaIdStudenta;
    }

    public void setOsobaIdStudenta(int osobaIdStudenta) {
        this.osobaIdStudenta = osobaIdStudenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZgloszeniePK that = (ZgloszeniePK) o;

        if (idZgloszenia != that.idZgloszenia) return false;
        if (pokojIdPokoju != that.pokojIdPokoju) return false;
        if (osobaIdStudenta != that.osobaIdStudenta) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZgloszenia;
        result = 31 * result + pokojIdPokoju;
        result = 31 * result + osobaIdStudenta;
        return result;
    }
}
