package patterns.structural_pattern.proxy_securityproxy;

import patterns.structural_pattern.proxy_securityproxy.connectors.Connector;
import patterns.structural_pattern.proxy_securityproxy.connectors.SecurityProxyConnector;
import patterns.structural_pattern.proxy_securityproxy.connectors.SimpleConnector;

/**
 * Security Proxy
 *
 * SecurityProxyConnector (пакет connectors) будет производить проверку безопасности перед подключением.
 * В случае, если проверка не пройдена, соединение не должно быть установлено.
 *
 * Для клиента (см. класс Program) использование SecurityProxyConnector ничем не отличается
 * от использования класса SimpleConnector.
 */
public class Program {
    public static void main(String[] args) {
        Connector simpleConnector = new SimpleConnector("javarush.ru");
        System.out.println("Connecting with SimpleConnector...");
        simpleConnector.connect();

        System.out.println("----------------------------------------------------");

        Connector securityProxyConnector = new SecurityProxyConnector("google.com");
        System.out.println("Connecting with SecurityProxyConnector...");
        securityProxyConnector.connect();
    }
}
