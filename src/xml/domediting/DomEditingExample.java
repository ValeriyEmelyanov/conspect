package xml.domediting;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DomEditingExample {
    public static void main(String[] args)
            throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String filename = "src/xml/domediting/BookCatalogue.xml";
        String filename2 = "src/xml/domediting/BookCatalogue2.xml";

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(filename);

        addNewBook(document);

        writeDocument(document, filename2);
    }

    private static void addNewBook(Document document) {
        Node root = document.getDocumentElement();

        Element book = document.createElement("Book");

        Element title = document.createElement("Title");
        title.setTextContent("Incredible book about Java");

        Element author = document.createElement("Author");
        author.setTextContent("Saburov Anton");

        Element date = document.createElement("Date");
        date.setTextContent("2015");

        Element isbn = document.createElement("ISBN");
        isbn.setTextContent("0-06-999999-9");

        Element publisher = document.createElement("Publisher");
        publisher.setTextContent("Java-Course publisher");

        Element cost = document.createElement("Cost");
        cost.setTextContent("499");
        cost.setAttribute("currency", "RUB");

        book.appendChild(title);
        book.appendChild(author);
        book.appendChild(date);
        book.appendChild(isbn);
        book.appendChild(publisher);
        book.appendChild(cost);

        root.appendChild(book);
    }

    private static void writeDocument(Document document, String filename)
            throws TransformerException, FileNotFoundException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        FileOutputStream fos = new FileOutputStream(filename);
        StreamResult streamResult = new StreamResult(fos);
        transformer.transform(source, streamResult);
    }
}
