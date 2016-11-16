package models;

import javax.persistence.*;

/**
 * Created by barte on 16/11/2016.
 */
@Entity
@IdClass(PokojPK.class)
public class Pokoj {
    private int idPokoju;
    private Integer liczbaMiejsc;
    private Integer pietro;
    private Integer cena;
    private int akademikIdAkademika;

    @Id
    @Column(name = "IdPokoju")
    public int getIdPokoju() {
        return idPokoju;
    }

    public void setIdPokoju(int idPokoju) {
        this.idPokoju = idPokoju;
    }

    @Basic
    @Column(name = "LiczbaMiejsc")
    public Integer getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    public void setLiczbaMiejsc(Integer liczbaMiejsc) {
        this.liczbaMiejsc = liczbaMiejsc;
    }

    @Basic
    @Column(name = "Pietro")
    public Integer getPietro() {
        return pietro;
    }

    public void setPietro(Integer pietro) {
        this.pietro = pietro;
    }

    @Basic
    @Column(name = "Cena")
    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
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

        Pokoj pokoj = (Pokoj) o;

        if (idPokoju != pokoj.idPokoju) return false;
        if (akademikIdAkademika != pokoj.akademikIdAkademika) return false;
        if (liczbaMiejsc != null ? !liczbaMiejsc.equals(pokoj.liczbaMiejsc) : pokoj.liczbaMiejsc != null) return false;
        if (pietro != null ? !pietro.equals(pokoj.pietro) : pokoj.pietro != null) return false;
        if (cena != null ? !cena.equals(pokoj.cena) : pokoj.cena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPokoju;
        result = 31 * result + (liczbaMiejsc != null ? liczbaMiejsc.hashCode() : 0);
        result = 31 * result + (pietro != null ? pietro.hashCode() : 0);
        result = 31 * result + (cena != null ? cena.hashCode() : 0);
        result = 31 * result + akademikIdAkademika;
        return result;
    }
}
