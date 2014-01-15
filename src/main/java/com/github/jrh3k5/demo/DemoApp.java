package com.github.jrh3k5.demo;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class DemoApp {
    public static void main(String[] args) {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new DemoBinder());
        resourceConfig.packages(true, DemoApp.class.getPackage().getName());
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://0.0.0.0:1337"), resourceConfig);
        try {
            server.start();
            while (true) {
                Thread.sleep(50000);
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
