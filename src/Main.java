import models.Akademik;
import models.Pokoj;
import models.PokojPK;
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
import java.util.Map;

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

        //System.out.println(firstNameGenerator.generateFirstName());
        final Session session = getSession();
        try {
            Akademik akademik = EntityGenerator.GenerateAkademik();
            //Pokoj pokoj = EntityGenerator.GeneratePokoj(akademik.getIdAkademika());

            session.beginTransaction();

            int idAkademika = (int)session.save(akademik);



            Pokoj pokoj = EntityGenerator.GeneratePokoj(idAkademika);
             session.save(pokoj);

            System.out.println("Generated Identifier:"+ idAkademika);
            session.getTransaction().commit();
            session.close();
//            System.out.println("querying all the managed entities...");
//            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
//            for (Object key : metadataMap.keySet()) {
//                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
//                final String entityName = classMetadata.getEntityName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
        }
        catch (Exception exc){
            System.out.println(exc);
        }
        finally {
            session.close();
        }
    }
}