package models;

import javax.persistence.*;

/**
 * Created by barte on 02/11/2016.
 */
@Entity
@IdClass(WniosekPK.class)
public class Wniosek {
    private int idWniosku;
    private String dataZlozenia;
    private String stan;
    private int akademikIdAkademika;

    @Id
    @Column(name = "IdWniosku")
    public int getIdWniosku() {
        return idWniosku;
    }

    public void setIdWniosku(int idWniosku) {
        this.idWniosku = idWniosku;
    }

    @Basic
    @Column(name = "DataZlozenia")
    public String getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(String dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
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
    @Column(name = "Akademik_IdAkademika")
    public int getAkademikIdAkademika() {
        return akademikIdAkademika;
    }

    public void setAkademikIdAkademika(int akademikIdAkademika) {
        this.akademikIdAkademika = akademikIdAkademika;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wniosek wniosek = (Wniosek) o;

        if (idWniosku != wniosek.idWniosku) return false;
        if (akademikIdAkademika != wniosek.akademikIdAkademika) return false;
        if (dataZlozenia != null ? !dataZlozenia.equals(wniosek.dataZlozenia) : wniosek.dataZlozenia != null)
            return false;
        if (stan != null ? !stan.equals(wniosek.stan) : wniosek.stan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWniosku;
        result = 31 * result + (dataZlozenia != null ? dataZlozenia.hashCode() : 0);
        result = 31 * result + (stan != null ? stan.hashCode() : 0);
        result = 31 * result + akademikIdAkademika;
        return result;
    }
}
