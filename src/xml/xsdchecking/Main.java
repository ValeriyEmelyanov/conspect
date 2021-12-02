package xml.xsdchecking;

public class Main {
    public static void main(String[] args) {
        String xsdPath = "src/xml/xsdchecking/Message.xsd";
        String xmlPath = "src/xml/xsdchecking/Message.xml";

        boolean result = XsdValidator.validate(xsdPath, xmlPath);
        System.out.println("Result: " + result);
    }
}
