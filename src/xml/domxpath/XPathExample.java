package xml.domxpath;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

public class XPathExample {
    public static void main(String[] args)
            throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        final String filename = "src/xml/domxpath/BookCatalogue.xml";

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(filename);

        printCost1(document);
        printCost2(document);
        printCost3(document);
        printCost4(document);
        printCost5(document);
    }

    // Печать всех элементов Cost
    private static void printCost1(Document document) throws XPathExpressionException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();

        // Полный путь до элемента
        //XPathExpression expr = xpath.compile("BookCatalogue/Book/Cost");
        // Все элементы с таким именем
        //XPathExpression expr = xpath.compile("//Cost");

        // Элементы, вложенные в другой элемент
        XPathExpression expr = xPath.compile("//Book/Cost");

        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        System.out.println("1) Печать всех элементов Cost");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Value: " + node.getTextContent());
        }
    }

    // Печать элементов Cost у которых атрибут currency='USD'
    private static void printCost2(Document document) throws XPathExpressionException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();

        XPathExpression expr = xPath.compile("BookCatalogue/Book/Cost[@currency='USD']");

        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        System.out.println("2) Печать элемента Cost у которого атрибут currency='USD'");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Value: " + node.getTextContent());
        }
    }

    // Печать элементов Book у которых значение Cost > 4
    private static void printCost3(Document document) throws XPathExpressionException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();

        XPathExpression expr = xPath.compile("BookCatalogue/Book[Cost > 4]");

        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        System.out.println("3) Печать элементов Book у которых значение Cost > 4");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Value: " + node.getTextContent());
        }
    }

    // Печать первого элемента Book
    private static void printCost4(Document document) throws XPathExpressionException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();

        XPathExpression expr = xPath.compile("BookCatalogue/Book[1]");

        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        System.out.println("4) Печать первого элемента Book");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Value: " + node.getTextContent());
        }
    }

    // Печать цены книги у которой Title начинается с Yogasana
    // Варианты доступа к относительным узлам:
    // ancestor , ancestor-or-self, descendant, descendant-or-self
    // following, following-sibling, namespace, preceding, preceding-sibling
    private static void printCost5(Document document) throws XPathExpressionException {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();

        XPathExpression expr = xPath.compile("BookCatalogue/Book/Cost"
                + "[starts-with(preceding-sibling::Title, 'Yogasana')"
                + " or "
                + "starts-with(following-sibling::Title, 'Yogasana')]");

        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        System.out.println("5) Печать цены книги у которой Title начинается с 'Yogasana'");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Value: " + node.getTextContent());
        }
    }

}
