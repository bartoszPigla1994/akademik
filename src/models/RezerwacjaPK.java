package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by barte on 16/11/2016.
 */
public class RezerwacjaPK implements Serializable {
    private int idRezerwacji;
    private int pokojIdPokoju;
    private int osobaIdPortiera;

    @Column(name = "IdRezerwacji")
    @Id
    public int getIdRezerwacji() {
        return idRezerwacji;
    }

    public void setIdRezerwacji(int idRezerwacji) {
        this.idRezerwacji = idRezerwacji;
    }

    @Column(name = "Pokoj_IdPokoju")
    @Id
    public int getPokojIdPokoju() {
        return pokojIdPokoju;
    }

    public void setPokojIdPokoju(int pokojIdPokoju) {
        this.pokojIdPokoju = pokojIdPokoju;
    }

    @Column(name = "Osoba_IdPortiera")
    @Id
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

        RezerwacjaPK that = (RezerwacjaPK) o;

        if (idRezerwacji != that.idRezerwacji) return false;
        if (pokojIdPokoju != that.pokojIdPokoju) return false;
        if (osobaIdPortiera != that.osobaIdPortiera) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRezerwacji;
        result = 31 * result + pokojIdPokoju;
        result = 31 * result + osobaIdPortiera;
        return result;
    }
}
