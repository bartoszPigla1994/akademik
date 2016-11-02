import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by barte on 02/11/2016.
 */
public class XmlFile {

    Document document;

    public XmlFile(String fileName){
        String abs=(new File(fileName)).getAbsolutePath();
        File fXmlFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(fXmlFile);
        }
        catch (Exception exc){

        }
    }

    public XmlFile(URL url){
        try{
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

            //your code
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse( inputStream );
        }
        catch(Exception exc){

        }
    }
    public Document getDocument(){
        return document;
    }
}
