package network.simple_httpserverv_and_httpclient;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8080), 0);
        server.createContext("/",
                new HttpHandler() {
                    @Override
                    public void handle(HttpExchange exchange) throws IOException {
                        String hello = "Hello, world";
                        exchange.sendResponseHeaders(200, hello.length());
                        exchange.getResponseBody().write(hello.getBytes());
                        exchange.getResponseBody().close();
                    }
                });
        server.createContext("/bye",
                new HttpHandler() {
                    @Override
                    public void handle(HttpExchange exchange) throws IOException {
                        String bye = "Bye";
                        exchange.sendResponseHeaders(200, bye.length());
                        exchange.getResponseBody().write(bye.getBytes());
                        exchange.getResponseBody().close();
                        //server.stop(1); // ?
                    }
                });
        server.start();
    }
}
