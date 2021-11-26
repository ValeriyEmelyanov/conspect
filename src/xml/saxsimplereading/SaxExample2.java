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

public class SaxExample2 {
    private static final List<Employee> EMPLOYEES = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        EmployeeHandler handler = new EmployeeHandler();
        parser.parse(new File("src/xml/saxsimplereading/employees2.xml"), handler);

        EMPLOYEES.forEach(System.out::println);
    }

    private static class EmployeeHandler extends DefaultHandler {
        private String name;
        private String position;
        private String currentElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = String.valueOf(ch, start, length);
            value = value.replaceAll("\n", " ").trim();
            if (value.isEmpty()) {
                return;
            }

            if ("name".equals(currentElementName)) {
                name = value;
            } else if ("position".equals(currentElementName)) {
                position = value;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("employee".equals(qName)) {
                EMPLOYEES.add(new Employee(name, position));
                name = null;
                position = null;
            }
        }
    }
}
