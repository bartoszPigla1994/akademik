import models.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

/**
 * Created by barte on 02/11/2016.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration
                    .addResource("hibernate.cfg.xml")
                    .configure();

            configuration.addAnnotatedClass(models.Akademik.class);
            configuration.addAnnotatedClass(models.Odwiedziny.class);
            configuration.addAnnotatedClass(models.Oplata.class);
            configuration.addAnnotatedClass(models.Osoba.class);
            configuration.addAnnotatedClass(models.Pokoj.class);
            configuration.addAnnotatedClass(models.Rezerwacja.class);
            configuration.addAnnotatedClass(models.Wniosek.class);
            configuration.addAnnotatedClass(models.Wyposazenie.class);
            configuration.addAnnotatedClass(models.Zakwaterowanie.class);
            configuration.addAnnotatedClass(models.Zgloszenie.class);

            configuration.addAnnotatedClass(models.Pokoj.class);

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        //XmlFile file = new XmlFile("src/resources/firstNames.xml");
        //XmlFile file=new XmlFile(new URL("http://www.thomas-bayer.com/restnames/namesincountry.groovy?country=Poland)"));
        //FirstNameGenerator firstNameGenerator=new FirstNameGenerator(file);
        // This will reference one line at a time

        String content = new String(Files.readAllBytes(Paths.get("src/address.xml")));

        //System.out.println(firstNameGenerator.generateFirstName());
        final Session session = getSession();
        try {
            Akademik akademik = EntityGenerator.GenerateAkademik();
            akademik.setIdAkademika(1);
            //Pokoj pokoj = EntityGenerator.GeneratePokoj(akademik.getIdAkademika());

            session.beginTransaction();

            int pkAkademik = (int)session.save(akademik);

            session.getTransaction().commit();
            List<PokojPK>pkPokojList=new ArrayList<>(1000);
            //int pkAkademik=1;
            //int idPokoju=1;
            session.beginTransaction();
            for(int i=1;i<=1000;i++){


                Pokoj pokoj = EntityGenerator.GeneratePokoj(i, pkAkademik);
                PokojPK pokojPK=(PokojPK)session.save(pokoj);
                //idPokoju++;
                pkPokojList.add(pokojPK);


                //session.close();
            }
            session.getTransaction().commit();
            //int idWyposazenia=1;
            session.beginTransaction();
            for(PokojPK pokojPK : pkPokojList){
                for(int i=1;i<=3;i++){
                    Wyposazenie w = EntityGenerator.GenerateWyposazenie(i, pokojPK.getIdPokoju());
                    //idWyposazenia++;
                    session.save(w);
                }
            }
            session.getTransaction().commit();

            List<Integer> pkOsobaList=new ArrayList<>(5000);

            List<Integer> pkPortierzyList=new ArrayList<>();
            List<Integer> pkStudenciList=new ArrayList<>();
            List<Integer> pkGoscieList=new ArrayList<>();
            List<Integer> pkKierownicyList = new ArrayList<>();
            List<Integer> pkPersonelList=new ArrayList<>();


            String[] typyOsob=new String[]{
                "Student",
                        "Portier",
                        "Gosc",
                        "Kierownik",
                        "Personel"
            };
            session.beginTransaction();
            for(int i=1;i<=5000;i++){
                Osoba osoba=EntityGenerator.GenerateOsoba(i, typyOsob);
                int pkOsoba=(int)session.save(osoba);
                pkOsobaList.add(pkOsoba);

                String typOsoby=osoba.getTyp();

                if(typOsoby.equals("Student"))
                    pkStudenciList.add(pkOsoba);
                else if(typOsoby.equals("Portier"))
                    pkPortierzyList.add(pkOsoba);
                else if(typOsoby.equals("Gosc"))
                    pkGoscieList.add(pkOsoba);
                else if(typOsoby.equals("Kierownik"))
                    pkKierownicyList.add(pkOsoba);
                else if(typOsoby.equals("Personel"))
                    pkPersonelList.add(pkOsoba);
            }
            session.getTransaction().commit();
            //List<OdwiedzinyPK>pkOdwiedziny=new ArrayList<>(7000);

            session.beginTransaction();
            for(int i=1;i<=7000;i++){
                Odwiedziny odwiedziny=EntityGenerator.GenerateOdwiedziny(i, pkStudenciList,pkPortierzyList,pkGoscieList);
                session.save(odwiedziny);
                //pkOdwiedziny.add((OdwiedzinyPK)session.save(odwiedziny));
            }
            session.getTransaction().commit();

            session.beginTransaction();
            for(int i=1;i<=5000;i++){
                Rezerwacja rezerwacja=EntityGenerator.GenerateRezerwacja(i,pkStudenciList,pkPokojList);
                session.save(rezerwacja);
            }
            session.getTransaction().commit();

            session.beginTransaction();
            for(int i=1;i<=5000;i++){
                Zgloszenie zgloszenie=EntityGenerator.GenerateZgloszenie(i,pkPokojList,pkStudenciList);
                session.save(zgloszenie);
            }
            session.getTransaction().commit();

            session.beginTransaction();
            List<WniosekPK> pkWniosekList=new ArrayList<WniosekPK>(5000);
            for(int i=0;i<5000;i++){
                Wniosek wniosek=EntityGenerator.GenerateWniosek(i, pkAkademik);
                pkWniosekList.add((WniosekPK)session.save(wniosek));
            }
            session.getTransaction().commit();


            session.beginTransaction();
            for(int i=1;i<=5000;i++){
                Oplata oplata = EntityGenerator.GenerateOplata(i, pkWniosekList);
                session.save(oplata);
            }
            session.getTransaction().commit();
            //System.out.println("Generated Identifier:"+ idAkademika);
//            session.getTransaction().commit();
//            session.close();

        }
        catch (Exception exc){
            System.out.println(exc);
        }
        finally {
            session.close();
        }
    }
}