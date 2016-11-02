import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by barte on 02/11/2016.
 */
public class XmlFile {

    URL url;
    URLConnection urlConnection;
    InputStream inputStream;
    Document document;

    public XmlFile(URL url){
        this.url = url;
        try{
            urlConnection = url.openConnection();
            inputStream = new BufferedInputStream(urlConnection.getInputStream());

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
