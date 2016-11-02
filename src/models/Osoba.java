package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by barte on 02/11/2016.
 */
@Entity
public class Osoba {
    private int idOsoby;
    private String imie;
    private String nazwisko;
    private Integer pesel;
    private String adres;
    private String tel;
    private String typ;

    @Id
    @Column(name = "IdOsoby")
    public int getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(int idOsoby) {
        this.idOsoby = idOsoby;
    }

    @Basic
    @Column(name = "Imie")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "Nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "Pesel")
    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    @Basic
    @Column(name = "Adres")
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Basic
    @Column(name = "Tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "Typ")
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Osoba osoba = (Osoba) o;

        if (idOsoby != osoba.idOsoby) return false;
        if (imie != null ? !imie.equals(osoba.imie) : osoba.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(osoba.nazwisko) : osoba.nazwisko != null) return false;
        if (pesel != null ? !pesel.equals(osoba.pesel) : osoba.pesel != null) return false;
        if (adres != null ? !adres.equals(osoba.adres) : osoba.adres != null) return false;
        if (tel != null ? !tel.equals(osoba.tel) : osoba.tel != null) return false;
        if (typ != null ? !typ.equals(osoba.typ) : osoba.typ != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOsoby;
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (typ != null ? typ.hashCode() : 0);
        return result;
    }
}
