import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by barte on 02/11/2016.
 */
public class XmlFile {

    Document document;

    public XmlFile(String fileName){
        String abs=(new File(fileName)).getAbsolutePath();
        //InputSource is = new InputSource(abs);

        try {
            FileReader fileReader =
                    new FileReader(abs);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(fileReader.toString());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
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
