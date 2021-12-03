package xml.xsltconversion;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XlsConverter {

    public String xmlToString(String xmlPath, String xlsPath)
            throws FileNotFoundException, TransformerException {
        InputStream xmlStream = new FileInputStream(xmlPath);
        InputStream xlsStream = new FileInputStream(xlsPath);

        StreamSource xmlSource = new StreamSource(xmlStream);
        StreamSource xlsSource = new StreamSource(xlsStream);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StreamResult xmlOutput = new StreamResult(baos);
        Transformer transformer = TransformerFactory.newInstance().newTransformer(xlsSource);

        transformer.transform(xmlSource, xmlOutput);

        return baos.toString();
    }

}
