package xml.saxsimplereading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxExample1 {
    private static final List<Employee> EMPLOYEES = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        EmployeeHandler handler = new EmployeeHandler();
        parser.parse(new File("src/xml/saxsimplereading/employees1.xml"), handler);

        EMPLOYEES.forEach(System.out::println);
    }

    private static class EmployeeHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("employee")) {
                String name = attributes.getValue("name");
                String position = attributes.getValue("position");
                EMPLOYEES.add(new Employee(name, position));
            }
        }
    }
}
