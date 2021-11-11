package xml.jaxbsave;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;

public class JabxExample {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Lokesh", "Gupta", new Department(101, "IT"));
        employee.setHobbies(Arrays.asList("Swimming","Playing", "Karate"));

        jaxbObjectToXml(employee);
    }

    public static void jaxbObjectToXml(Employee employee) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(employee, new File("employee.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
