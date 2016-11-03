package models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by barte on 03/11/2016.
 */
@Entity
@IdClass(ZakwaterowaniePK.class)
public class Zakwaterowanie {
    private int idZakwaterowania;
    private Date dataPoczatek;
    private Date dataKoniec;
    private int wniosekIdWniosku;
    private int pokojIdPokoju;

    @Id
    @Column(name = "IdZakwaterowania")
    public int getIdZakwaterowania() {
        return idZakwaterowania;
    }

    public void setIdZakwaterowania(int idZakwaterowania) {
        this.idZakwaterowania = idZakwaterowania;
    }

    @Basic
    @Column(name = "DataPoczatek")
    public Date getDataPoczatek() {
        return dataPoczatek;
    }

    public void setDataPoczatek(Date dataPoczatek) {
        this.dataPoczatek = dataPoczatek;
    }

    @Basic
    @Column(name = "DataKoniec")
    public Date getDataKoniec() {
        return dataKoniec;
    }

    public void setDataKoniec(Date dataKoniec) {
        this.dataKoniec = dataKoniec;
    }

    @Id
    @Column(name = "Wniosek_IdWniosku")
    public int getWniosekIdWniosku() {
        return wniosekIdWniosku;
    }

    public void setWniosekIdWniosku(int wniosekIdWniosku) {
        this.wniosekIdWniosku = wniosekIdWniosku;
    }

    @Id
    @Column(name = "Pokoj_idPokoju")
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

        Zakwaterowanie that = (Zakwaterowanie) o;

        if (idZakwaterowania != that.idZakwaterowania) return false;
        if (wniosekIdWniosku != that.wniosekIdWniosku) return false;
        if (pokojIdPokoju != that.pokojIdPokoju) return false;
        if (dataPoczatek != null ? !dataPoczatek.equals(that.dataPoczatek) : that.dataPoczatek != null) return false;
        if (dataKoniec != null ? !dataKoniec.equals(that.dataKoniec) : that.dataKoniec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZakwaterowania;
        result = 31 * result + (dataPoczatek != null ? dataPoczatek.hashCode() : 0);
        result = 31 * result + (dataKoniec != null ? dataKoniec.hashCode() : 0);
        result = 31 * result + wniosekIdWniosku;
        result = 31 * result + pokojIdPokoju;
        return result;
    }
}
