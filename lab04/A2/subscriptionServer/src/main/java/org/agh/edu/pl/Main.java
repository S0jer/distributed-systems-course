package org.agh.edu.pl;


import org.agh.edu.pl.server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.start();
        server.blockUntilShutdown();
    }
}