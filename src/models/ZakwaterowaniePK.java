package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by barte on 03/11/2016.
 */
public class ZakwaterowaniePK implements Serializable {
    private int idZakwaterowania;
    private int wniosekIdWniosku;
    private int pokojIdPokoju;

    @Column(name = "IdZakwaterowania")
    @Id
    public int getIdZakwaterowania() {
        return idZakwaterowania;
    }

    public void setIdZakwaterowania(int idZakwaterowania) {
        this.idZakwaterowania = idZakwaterowania;
    }

    @Column(name = "Wniosek_IdWniosku")
    @Id
    public int getWniosekIdWniosku() {
        return wniosekIdWniosku;
    }

    public void setWniosekIdWniosku(int wniosekIdWniosku) {
        this.wniosekIdWniosku = wniosekIdWniosku;
    }

    @Column(name = "Pokoj_idPokoju")
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

        ZakwaterowaniePK that = (ZakwaterowaniePK) o;

        if (idZakwaterowania != that.idZakwaterowania) return false;
        if (wniosekIdWniosku != that.wniosekIdWniosku) return false;
        if (pokojIdPokoju != that.pokojIdPokoju) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZakwaterowania;
        result = 31 * result + wniosekIdWniosku;
        result = 31 * result + pokojIdPokoju;
        return result;
    }
}
