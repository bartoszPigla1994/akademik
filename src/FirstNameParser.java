import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.function.Predicate;

/**
 * Created by barte on 02/11/2016.
 */
public class FirstNameParser {
    URL url;
    URLConnection urlConnection;
    InputStream inputStream;
    Document document;
    int firstNameNumber;

    public FirstNameParser(URL url){
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

        getFirstNameCount();
    }

    private void getFirstNameCount(){

        NodeList nodeList=document.getElementsByTagName("name");
        firstNameNumber =nodeList.getLength();
    }

    public Predicate<Integer> isInFirstNameRange(){
        return firstNameIndex -> firstNameIndex>=0 && firstNameIndex<firstNameNumber;
    }

}
