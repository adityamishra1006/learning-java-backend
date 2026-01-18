package org.example.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SampleHTTPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting HTTP server...");
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 10);
        server.createContext("/hello", new HelloHandler());
        server.setExecutor(Executors.newFixedThreadPool(4));
        server.start();// creates a default executor
    }
}
