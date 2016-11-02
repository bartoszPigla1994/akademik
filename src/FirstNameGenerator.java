import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Random;
import java.util.function.Predicate;

/**
 * Created by barte on 02/11/2016.
 */
public class FirstNameGenerator {
    Document document;
    NodeList nodeList;
    int firstNameNumber;
    Random random=new Random();

    public FirstNameGenerator(XmlFile file){
        document=file.getDocument();
        nodeList=document.getElementsByTagName("name");
        firstNameNumber =nodeList.getLength();
    }

    public String generateFirstName(){
        int firstNameIndex = random.nextInt(firstNameNumber - 1);
        Node node = nodeList.item(firstNameIndex);
        return node.toString();
    }
}
