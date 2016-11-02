package models;

import javax.persistence.*;

/**
 * Created by barte on 02/11/2016.
 */
@Entity
@IdClass(WyposazeniePK.class)
public class Wyposazenie {
    private int idWyposazenia;
    private String nazwa;
    private int pokojIdPokoju;

    @Id
    @Column(name = "IdWyposazenia")
    public int getIdWyposazenia() {
        return idWyposazenia;
    }

    public void setIdWyposazenia(int idWyposazenia) {
        this.idWyposazenia = idWyposazenia;
    }

    @Basic
    @Column(name = "Nazwa")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Id
    @Column(name = "Pokoj_IdPokoju")
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

        Wyposazenie that = (Wyposazenie) o;

        if (idWyposazenia != that.idWyposazenia) return false;
        if (pokojIdPokoju != that.pokojIdPokoju) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWyposazenia;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + pokojIdPokoju;
        return result;
    }
}
