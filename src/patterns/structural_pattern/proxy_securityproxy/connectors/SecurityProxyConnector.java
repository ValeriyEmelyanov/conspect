package patterns.structural_pattern.proxy_securityproxy.connectors;

import patterns.structural_pattern.proxy_securityproxy.security.SecurityChecker;
import patterns.structural_pattern.proxy_securityproxy.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SecurityChecker checker = new SecurityCheckerImpl();
    private SimpleConnector connector;

    public SecurityProxyConnector(String resourceString) {
        connector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if (checker.performSecurityCheck()) {
            connector.connect();
        }
    }
}
