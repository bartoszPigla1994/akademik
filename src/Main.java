import models.*;
import org.hibernate.*;
import org.hibernate.boot.jaxb.cfg.spi.ObjectFactory;
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

    public static void GenerateRows(){
        final Session session = getSession();
        try {
            int pkAkademik=1;
            Akademik akademik = EntityGenerator.GenerateAkademik(pkAkademik);

            session.beginTransaction();

            pkAkademik = (int)session.save(akademik);

            session.getTransaction().commit();

            List<PokojPK>pkPokojList=new ArrayList<>(1000);

            session.beginTransaction();
            for(int i=1;i<=1000;i++){
                Pokoj pokoj = EntityGenerator.GeneratePokoj(i, pkAkademik);
                PokojPK pokojPK=(PokojPK)session.save(pokoj);
                pkPokojList.add(pokojPK);
            }
            session.getTransaction().commit();

            session.beginTransaction();
            for(PokojPK pokojPK : pkPokojList){
                for(int i=1;i<=3;i++){
                    Wyposazenie w = EntityGenerator.GenerateWyposazenie(i, pokojPK.getIdPokoju());
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
            List<Osoba> osoby = new ArrayList<>();

            session.beginTransaction();
            for(int i=1;i<=5000;i++){
                Osoba osoba=EntityGenerator.GenerateOsoba(i);
                osoby.add(osoba);
                Integer pkOsoba=(Integer)session.save(osoba);
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

            session.beginTransaction();
            for(int i=1;i<=7000;i++){
                Odwiedziny odwiedziny=EntityGenerator.GenerateOdwiedziny(i, pkStudenciList,pkPortierzyList,pkGoscieList);
                session.save(odwiedziny);
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

            session.beginTransaction();
            for(int i=1;i<=5000;i++){
                Zakwaterowanie zakwaterowanie = EntityGenerator.GenerateZakwaterowanie(i,pkPokojList, pkWniosekList);
                session.save(zakwaterowanie);
            }
            session.getTransaction().commit();
        }
        catch (Exception exc){
            System.out.println(exc);
        }
        finally {
            session.close();
        }
    }

    public static void GenerateOdwiedzinyWithNotExistingForeignKey(){
        List<Integer> notExistingFk=new ArrayList<>();
        notExistingFk.add(11000);

        Odwiedziny o=EntityGenerator.GenerateOdwiedziny(7001,notExistingFk,notExistingFk,notExistingFk);

        final Session session = getSession();

        try{
            session.beginTransaction();

            session.save(o);

            session.getTransaction().commit();
        }
        catch (Exception exc){
            System.out.println(exc);
        }
        finally{
            session.close();
        }

    }

    public static void main(final String[] args) throws Exception {
        //GenerateRows();
        GenerateOdwiedzinyWithNotExistingForeignKey();
    }
}