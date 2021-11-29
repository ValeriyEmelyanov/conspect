package xml.staxsimple;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxReadExamle {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        final String fileName = "src/xml/staxsimple/BookCatalog.xml";

        XMLStreamReader reader = XMLInputFactory.newInstance()
                .createXMLStreamReader(fileName, new FileInputStream(fileName));

        while (reader.hasNext()) {
            reader.next();
            if (reader.isStartElement()) {
                System.out.print("\n" + reader.getLocalName());
            } else if (reader.hasText()) {
                System.out.print(": " + reader.getText());
            }
        }

        reader.close();
    }
}
