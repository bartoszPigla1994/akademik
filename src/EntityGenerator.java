import models.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by barte on 02/11/2016.
 */
public class EntityGenerator {
    static Random random = new Random();
    static List<String> namesList = new ArrayList<String>();
    static List<String> surNamesList = new ArrayList<String>();
    static List<String> addressList = new ArrayList<String>();
    static List<String> wyposazenieList = new ArrayList<String>();

    static int namesCount;
    static int surnamesCount;
    static int addressCount;
    static int wyposazenieCount;

    static{
        loadNames();
        loadSurNames();
        loadAddress();
        loadWyposazenie();
    }

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

    public static Oplata GenerateOplata(List<WniosekPK> pkWniosekList) {
        Oplata oplata=new Oplata();
        oplata.setDataNalozenia(GeneratData("2010-01-01 00:00:00","2015-12-31 00:58:00"));
        oplata.setDataOplaty(GeneratData("2010-01-01 00:00:00","2015-12-31 00:58:00"));
        oplata.setKwota(GenerateNumber(100,500));
        oplata.setStan("zaplacono");
        oplata.setWniosekIdWniosku(GenerateCollectionItem(pkWniosekList).getIdWniosku());
        return oplata;
    }

    public static Wniosek GenerateWniosek(int pkAkademik) {
        Wniosek wniosek = new Wniosek();
        wniosek.setStan("przyjety");
        wniosek.setAkademikIdAkademika(pkAkademik);
        wniosek.setDataZlozenia(GeneratData("2010-01-01 00:00:00","2015-12-31 00:58:00"));
        return wniosek;
    }

    public static Zgloszenie GenerateZgloszenie(List<PokojPK> pkPokojList, List<Integer> pkStudenciList) {
        Zgloszenie zgloszenie = new Zgloszenie();
        zgloszenie.setStan("gotowe");
        zgloszenie.setDataZgloszenia(GeneratData("2010-01-01 00:00:00","2015-12-31 00:58:00"));
        zgloszenie.setOsobaIdStudenta(GenerateCollectionItem(pkStudenciList));
        zgloszenie.setPokojIdPokoju(GenerateCollectionItem(pkPokojList).getIdPokoju());
        zgloszenie.setTemat("zgloszenie o przyjecie");
        zgloszenie.setTresc("Prosze o przyjecie zgloszenia");

        return zgloszenie;
    }

    public static Rezerwacja GenerateRezerwacja(List<Integer> pkStudenciList, List<PokojPK> pkPokojList) {
        Rezerwacja rezerwacja = new Rezerwacja();
        rezerwacja.setPokojIdPokoju(GenerateCollectionItem(pkPokojList).getIdPokoju());
        rezerwacja.setDataKoniec(GeneratData("2015-01-01 00:00:00","2015-12-31 00:58:00"));
        rezerwacja.setDataPoczatek(GeneratData("2012-01-01 00:00:00","2015-01-01 00:00:00"));
        rezerwacja.setOsobaIdPortiera(GenerateCollectionItem(pkStudenciList));

        return rezerwacja;
    }

    public static Odwiedziny GenerateOdwiedziny(List<Integer> pkStudenciList, List<Integer> pkPortierzyList, List<Integer> pkGoscieList) {
        Odwiedziny odwiedziny = new Odwiedziny();
        odwiedziny.setOsobaIdPortiera(GenerateCollectionItem(pkPortierzyList));
        odwiedziny.setOsobaIdGoscia(GenerateCollectionItem(pkGoscieList));
        odwiedziny.setOsobaIdStudenta(GenerateCollectionItem(pkStudenciList));
        odwiedziny.setData(GeneratData("2010-01-01 00:00:00","2015-12-31 00:58:00"));

        return odwiedziny;
    }

    private static <T> T GenerateCollectionItem(List<T> collection){
        return collection.get(GenerateNumber(0,collection.size()));
    }

    private static String GenerateTelefon() {
        String tel = Integer.toString((GenerateNumber(1,9)));
        for(int i = 0; i < 8; i++){
            tel += GenerateNumber(0,9);
        }
        return tel;
    }

    private static Integer GeneratePesel() {
        return 0;
    }

    private static String GenerateTyp() {
        return "";
    }

    static java.sql.Date GeneratData(String beginTimeStr, String endTimeStr){
        long beginTime = Timestamp.valueOf(beginTimeStr).getTime();
        long endTime = Timestamp.valueOf(endTimeStr).getTime();

        long diff = endTime - beginTime + 1;
        long date= beginTime + (long) (Math.random() * diff);

        return new java.sql.Date(date);
    }

    static String GenerateWyposazenie(){
//        if(wyposazenieList.size() == 0){
//            loadWyposazenie();
//        }
        int index = random.nextInt(wyposazenieCount);
        return wyposazenieList.get(index);
    }

    static String GenerateAdres(){
//        if(addressList.size() == 0){
//            loadAddress();
//        }
        int index = random.nextInt(addressCount);
        return addressList.get(index);
    }
    static String GenerateImie(){
//        if(namesList.size() == 0){
//            loadNames();
//        }
        int index = random.nextInt(namesCount);
        return namesList.get(index);
    }
    static String GenerateNazwisko(){
//        if(surNamesList.size() == 0){
//            loadSurNames();
//        }
        int index = random.nextInt(surnamesCount);
        return surNamesList.get(index);
    }

    static String GenerateSygnatura(){
        return "PWR_Ak-110";
    }

    static int GenerateNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static InputSource loadFile(String path){
//        String xml = null;
//        try {
//            xml = new String(Files.readAllBytes(Paths.get(path)));
//            //xml = xml.trim().replaceFirst("^([\\W]+)<","<");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new InputSource(new StringReader(xml));

        boolean firstLine = true;
        StringBuilder sb = new StringBuilder();
        try{
            FileInputStream fis = new FileInputStream(path);
            BufferedReader r = new BufferedReader(new InputStreamReader(fis,
                    "UTF-16"));
            for (String s = ""; (s = r.readLine()) != null;) {
                if (firstLine) {
                    s = removeUTF8BOM(s);

                    firstLine = false;
                }
                sb.append(s);
            }
            r.close();
        }
        catch(Exception exc){

        }
        String xml=sb.toString();
        return new InputSource(new StringReader(xml));
//
//
//
//        String line;
//        StringBuilder sb = new StringBuilder();
//
//        try {
//
//            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
//            while((line=br.readLine())!= null){
//                sb.append(line.trim());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static String removeUTF8BOM(String s) {
        if (s.startsWith("\uFEFF")) {
            s = s.substring(1);
        }
        return s;
    }

    public static void loadNames(){



        try {
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(loadFile("src/firstNames.xml"));
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("firstName");
            namesCount=nList.getLength();
            for (int temp = 0; temp < namesCount; temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    namesList.add(eElement.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadSurNames(){
        try {
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(loadFile("src/surNames.xml"));
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("surName");
            surnamesCount=nList.getLength();
            for (int temp = 0; temp < surnamesCount; temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    surNamesList.add(eElement.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadAddress(){
        try {

//            File inputFile = new File("src/address.xml");
//            String absolutePath=inputFile.getAbsolutePath();
            //InputStream is=new
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(loadFile("src/address.xml"));
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("address");
            addressCount=nList.getLength();
            for (int temp = 0; temp < addressCount; temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    addressList.add(eElement.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadWyposazenie(){
        try {
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(loadFile("src/wyposazenia.xml"));
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("wyposazenie");
            wyposazenieCount=nList.getLength();
            for (int temp = 0; temp < wyposazenieCount; temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    wyposazenieList.add(eElement.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
