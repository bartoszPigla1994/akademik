package models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by barte on 02/11/2016.
 */
@Entity
@IdClass(RezerwacjaPK.class)
public class Rezerwacja {
    private int idRezerwacji;
    private Date dataPoczatek;
    private Date dataKoniec;
    private int pokojIdPokoju;
    private int osobaIdPortiera;

    @Id
    @Column(name = "IdRezerwacji")
    public int getIdRezerwacji() {
        return idRezerwacji;
    }

    public void setIdRezerwacji(int idRezerwacji) {
        this.idRezerwacji = idRezerwacji;
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
    @Column(name = "Pokoj_IdPokoju")
    public int getPokojIdPokoju() {
        return pokojIdPokoju;
    }

    public void setPokojIdPokoju(int pokojIdPokoju) {
        this.pokojIdPokoju = pokojIdPokoju;
    }

    @Id
    @Column(name = "Osoba_IdPortiera")
    public int getOsobaIdPortiera() {
        return osobaIdPortiera;
    }

    public void setOsobaIdPortiera(int osobaIdPortiera) {
        this.osobaIdPortiera = osobaIdPortiera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rezerwacja that = (Rezerwacja) o;

        if (idRezerwacji != that.idRezerwacji) return false;
        if (pokojIdPokoju != that.pokojIdPokoju) return false;
        if (osobaIdPortiera != that.osobaIdPortiera) return false;
        if (dataPoczatek != null ? !dataPoczatek.equals(that.dataPoczatek) : that.dataPoczatek != null) return false;
        if (dataKoniec != null ? !dataKoniec.equals(that.dataKoniec) : that.dataKoniec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRezerwacji;
        result = 31 * result + (dataPoczatek != null ? dataPoczatek.hashCode() : 0);
        result = 31 * result + (dataKoniec != null ? dataKoniec.hashCode() : 0);
        result = 31 * result + pokojIdPokoju;
        result = 31 * result + osobaIdPortiera;
        return result;
    }
}
