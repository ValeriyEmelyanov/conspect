package xml.domsimplereading;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xml.saxsimplereading.Employee;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomExample {
    private static final List<Employee> EMPLOYEES = new ArrayList<>();

    public static void main(String[] args)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("src/xml/domsimplereading/employees1.xml"));

        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node item = employeeElements.item(i);
            NamedNodeMap attributes = item.getAttributes();
            EMPLOYEES.add(new Employee(
                    attributes.getNamedItem("name").getNodeValue(),
                    attributes.getNamedItem("position").getNodeValue()));
        }

        EMPLOYEES.forEach(System.out::println);
    }
}
