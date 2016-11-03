package models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by barte on 03/11/2016.
 */
@Entity
@IdClass(OplataPK.class)
public class Oplata {
    private int idOplaty;
    private Integer kwota;
    private String stan;
    private Date dataNalozenia;
    private Date dataOplaty;
    private int wniosekIdWniosku;

    @Id
    @Column(name = "IdOplaty")
    public int getIdOplaty() {
        return idOplaty;
    }

    public void setIdOplaty(int idOplaty) {
        this.idOplaty = idOplaty;
    }

    @Basic
    @Column(name = "Kwota")
    public Integer getKwota() {
        return kwota;
    }

    public void setKwota(Integer kwota) {
        this.kwota = kwota;
    }

    @Basic
    @Column(name = "Stan")
    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    @Basic
    @Column(name = "DataNalozenia")
    public Date getDataNalozenia() {
        return dataNalozenia;
    }

    public void setDataNalozenia(Date dataNalozenia) {
        this.dataNalozenia = dataNalozenia;
    }

    @Basic
    @Column(name = "DataOplaty")
    public Date getDataOplaty() {
        return dataOplaty;
    }

    public void setDataOplaty(Date dataOplaty) {
        this.dataOplaty = dataOplaty;
    }

    @Id
    @Column(name = "Wniosek_IdWniosku")
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

        Oplata oplata = (Oplata) o;

        if (idOplaty != oplata.idOplaty) return false;
        if (wniosekIdWniosku != oplata.wniosekIdWniosku) return false;
        if (kwota != null ? !kwota.equals(oplata.kwota) : oplata.kwota != null) return false;
        if (stan != null ? !stan.equals(oplata.stan) : oplata.stan != null) return false;
        if (dataNalozenia != null ? !dataNalozenia.equals(oplata.dataNalozenia) : oplata.dataNalozenia != null)
            return false;
        if (dataOplaty != null ? !dataOplaty.equals(oplata.dataOplaty) : oplata.dataOplaty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOplaty;
        result = 31 * result + (kwota != null ? kwota.hashCode() : 0);
        result = 31 * result + (stan != null ? stan.hashCode() : 0);
        result = 31 * result + (dataNalozenia != null ? dataNalozenia.hashCode() : 0);
        result = 31 * result + (dataOplaty != null ? dataOplaty.hashCode() : 0);
        result = 31 * result + wniosekIdWniosku;
        return result;
    }
}
