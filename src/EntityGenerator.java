import models.*;

import java.util.List;
import java.util.Random;

/**
 * Created by barte on 02/11/2016.
 */
public class EntityGenerator {
    static Random random = new Random();

    public static Akademik GenerateAkademik() {
        Akademik akademik = new Akademik();
        akademik.setAdres(GenerateAdres());
        akademik.setSygnatura(GenerateSygnatura());
        return akademik;
    }

    public static Pokoj GeneratePokoj(int idAkademika) {
        Pokoj pokoj = new Pokoj();
        pokoj.setAkademikIdAkademika(idAkademika);
        pokoj.setCena(GenerateNumber(100, 500));
        pokoj.setLiczbaMiejsc(GenerateNumber(2, 5));
        pokoj.setPietro(GenerateNumber(0, 5));
        return pokoj;
    }

    public static Wyposazenie GenerateWyposazenie(int idPokoju){
        Wyposazenie wyposazenie=new Wyposazenie();
        wyposazenie.setNazwa(GenerateWyposazenie());
        wyposazenie.setPokojIdPokoju(idPokoju);
        return wyposazenie;
    }

    public static Osoba GenerateOsoba(String[]typyOsob){
        Osoba osoba=new Osoba();
        osoba.setAdres(GenerateAdres());
        osoba.setImie(GenerateImie());
        osoba.setNazwisko(GenerateNazwisko());
        osoba.setPesel(GeneratePesel());
        osoba.setTel(GenerateTelefon());
        osoba.setTyp(typyOsob[GenerateNumber(0,4)]);
        return osoba;
    }

    private static String GenerateTelefon() {
        return "";
    }


    private static Integer GeneratePesel() {
        return 0;
    }

    private static String GenerateTyp() {
        return "";
    }

    static String GenerateWyposazenie(){
        return "";
    }

    static String GenerateAdres(){
        return "";
    }
    static String GenerateImie(){
        return "";
    }
    static String GenerateNazwisko(){
        return "";
    }

    static String GenerateSygnatura(){
        return "";
    }

    static int GenerateNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static Oplata GenerateOplata(List<WniosekPK> pkWniosekList) {
    }

    public static Wniosek GenerateWniosek(int pkAkademik) {
    }

    public static Zgloszenie GenerateZgloszenie(List<PokojPK> pkPokojList, List<Integer> pkStudenciList) {
    }

    public static Rezerwacja GenerateRezerwacja(List<Integer> pkStudenciList, List<PokojPK> pkPokojList) {
    }

    public static Odwiedziny GenerateOdwiedziny(List<Integer> pkStudenciList, List<Integer> pkPortierzyList, List<Integer> pkGoscieList) {
    }
}
