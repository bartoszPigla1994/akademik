import models.Akademik;
import models.Pokoj;

import java.util.Random;

/**
 * Created by barte on 02/11/2016.
 */
public class EntityGenerator {
    static Random random = new Random();

    public static Akademik GenerateAkademik() {
        Akademik akademik = new Akademik();
        akademik.setIdAkademika(1);
        akademik.setAdres("ul. Wolna 21/13 54-342 Wroclaw");
        akademik.setSygnatura("AKPwr-001");
        return akademik;
    }

    public static Pokoj GeneratePokoj(int idPokoju) {
        Pokoj pokoj = new Pokoj();
        pokoj.setAkademikIdAkademika(1);
        pokoj.setCena(GenerateNumber(100, 500));
        pokoj.setIdPokoju(idPokoju);
        pokoj.setLiczbaMiejsc(GenerateNumber(2, 5));
        pokoj.setPietro(GenerateNumber(0, 5));
        return pokoj;
    }

    static int GenerateNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
