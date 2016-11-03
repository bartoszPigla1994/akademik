package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by barte on 03/11/2016.
 */
public class WniosekPK implements Serializable {
    private int idWniosku;
    private int akademikIdAkademika;

    @Column(name = "IdWniosku")
    @Id
    public int getIdWniosku() {
        return idWniosku;
    }

    public void setIdWniosku(int idWniosku) {
        this.idWniosku = idWniosku;
    }

    @Column(name = "Akademik_IdAkademika")
    @Id
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

        WniosekPK wniosekPK = (WniosekPK) o;

        if (idWniosku != wniosekPK.idWniosku) return false;
        if (akademikIdAkademika != wniosekPK.akademikIdAkademika) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWniosku;
        result = 31 * result + akademikIdAkademika;
        return result;
    }
}
