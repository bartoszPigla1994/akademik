import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
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
        nodeList=document.getElementsByTagName("nameInfo");
        firstNameNumber =nodeList.getLength();
    }

    public String generateFirstName(){
        List<String> firstNames = new ArrayList<>();

        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            //We have encountered an <employee> tag.
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    //Identifying the child tag of employee encountered.
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().
                                getTextContent().trim();
                        switch (cNode.getNodeName()) {
                            case "name":
                                firstNames.add(content);
                        }
                    }
                }
            }
        }
        int idx = EntityGenerator.GenerateNumber(0,firstNames.size());
        return firstNames.get(idx);
    }
}
