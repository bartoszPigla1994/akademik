package models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by barte on 16/11/2016.
 */
@Entity
@IdClass(ZgloszeniePK.class)
public class Zgloszenie {
    private int idZgloszenia;
    private String temat;
    private String tresc;
    private Date dataZgloszenia;
    private String stan;
    private int pokojIdPokoju;
    private int osobaIdStudenta;

    @Id
    @Column(name = "IdZgloszenia")
    public int getIdZgloszenia() {
        return idZgloszenia;
    }

    public void setIdZgloszenia(int idZgloszenia) {
        this.idZgloszenia = idZgloszenia;
    }

    @Basic
    @Column(name = "Temat")
    public String getTemat() {
        return temat;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    @Basic
    @Column(name = "Tresc")
    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    @Basic
    @Column(name = "DataZgloszenia")
    public Date getDataZgloszenia() {
        return dataZgloszenia;
    }

    public void setDataZgloszenia(Date dataZgloszenia) {
        this.dataZgloszenia = dataZgloszenia;
    }

    @Basic
    @Column(name = "Stan")
    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
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
    @Column(name = "Osoba_IdStudenta")
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

        Zgloszenie that = (Zgloszenie) o;

        if (idZgloszenia != that.idZgloszenia) return false;
        if (pokojIdPokoju != that.pokojIdPokoju) return false;
        if (osobaIdStudenta != that.osobaIdStudenta) return false;
        if (temat != null ? !temat.equals(that.temat) : that.temat != null) return false;
        if (tresc != null ? !tresc.equals(that.tresc) : that.tresc != null) return false;
        if (dataZgloszenia != null ? !dataZgloszenia.equals(that.dataZgloszenia) : that.dataZgloszenia != null)
            return false;
        if (stan != null ? !stan.equals(that.stan) : that.stan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZgloszenia;
        result = 31 * result + (temat != null ? temat.hashCode() : 0);
        result = 31 * result + (tresc != null ? tresc.hashCode() : 0);
        result = 31 * result + (dataZgloszenia != null ? dataZgloszenia.hashCode() : 0);
        result = 31 * result + (stan != null ? stan.hashCode() : 0);
        result = 31 * result + pokojIdPokoju;
        result = 31 * result + osobaIdStudenta;
        return result;
    }
}
