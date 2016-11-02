package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by barte on 02/11/2016.
 */
public class WyposazeniePK implements Serializable {
    private int idWyposazenia;
    private int pokojIdPokoju;

    @Column(name = "IdWyposazenia")
    @Id
    public int getIdWyposazenia() {
        return idWyposazenia;
    }

    public void setIdWyposazenia(int idWyposazenia) {
        this.idWyposazenia = idWyposazenia;
    }

    @Column(name = "Pokoj_IdPokoju")
    @Id
    public int getPokojIdPokoju() {
        return pokojIdPokoju;
    }

    public void setPokojIdPokoju(int pokojIdPokoju) {
        this.pokojIdPokoju = pokojIdPokoju;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WyposazeniePK that = (WyposazeniePK) o;

        if (idWyposazenia != that.idWyposazenia) return false;
        if (pokojIdPokoju != that.pokojIdPokoju) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWyposazenia;
        result = 31 * result + pokojIdPokoju;
        return result;
    }
}
