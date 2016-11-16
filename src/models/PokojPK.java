package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by barte on 16/11/2016.
 */
public class PokojPK implements Serializable {
    private int idPokoju;
    private int akademikIdAkademika;

    @Column(name = "IdPokoju")
    @Id
    public int getIdPokoju() {
        return idPokoju;
    }

    public void setIdPokoju(int idPokoju) {
        this.idPokoju = idPokoju;
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

        PokojPK pokojPK = (PokojPK) o;

        if (idPokoju != pokojPK.idPokoju) return false;
        if (akademikIdAkademika != pokojPK.akademikIdAkademika) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPokoju;
        result = 31 * result + akademikIdAkademika;
        return result;
    }
}
