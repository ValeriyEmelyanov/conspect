package xml.staxsimple;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StaxWriteExample {
    public static void main(String[] args) throws IOException, XMLStreamException {
        final String fileName = "src/xml/staxsimple/BookCatalog.xml";

        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(fileName));

        writer.writeStartDocument("1.0");
        writer.writeStartElement("BookCatalogue");
        for (int i = 0; i < 5; i++) {
            writer.writeStartElement("Book");

            writer.writeStartElement("Title");
            writer.writeCharacters("Book #" + i);
            writer.writeEndElement();

            writer.writeStartElement("ISBN");
            writer.writeCharacters("ISBN #" + i);
            writer.writeEndElement();

            writer.writeEndElement();
        }
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.close();
    }
}
