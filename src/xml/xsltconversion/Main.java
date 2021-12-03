package xml.xsltconversion;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, TransformerException {
        String xmlPath = "src/xml/xsltconversion/BookCatalog.xml";
        String xlsPath = "src/xml/xsltconversion/BookCatalog.xsl";

        XlsConverter converter = new XlsConverter();
        String result = converter.xmlToString(xmlPath, xlsPath);
        System.out.println(result);
    }

}
