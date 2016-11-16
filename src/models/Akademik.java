package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by barte on 16/11/2016.
 */
@Entity
public class Akademik {
    private int idAkademika;
    private String adres;
    private String sygnatura;

    @Id
    @Column(name = "IdAkademika")
    public int getIdAkademika() {
        return idAkademika;
    }

    public void setIdAkademika(int idAkademika) {
        this.idAkademika = idAkademika;
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
    @Column(name = "Sygnatura")
    public String getSygnatura() {
        return sygnatura;
    }

    public void setSygnatura(String sygnatura) {
        this.sygnatura = sygnatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Akademik akademik = (Akademik) o;

        if (idAkademika != akademik.idAkademika) return false;
        if (adres != null ? !adres.equals(akademik.adres) : akademik.adres != null) return false;
        if (sygnatura != null ? !sygnatura.equals(akademik.sygnatura) : akademik.sygnatura != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAkademika;
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + (sygnatura != null ? sygnatura.hashCode() : 0);
        return result;
    }
}
