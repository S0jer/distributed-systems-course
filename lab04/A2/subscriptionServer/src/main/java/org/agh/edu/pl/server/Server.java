package org.agh.edu.pl.server;

import io.grpc.netty.NettyServerBuilder;
import org.agh.edu.pl.service.NbaStatsGrpcImpl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;

public class Server {
    private final int port = 50051;
    private final String address = "127.0.0.1";
    private io.grpc.Server server;
    private final SocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName(address), port);

    public Server() throws UnknownHostException {
    }

    public void start() throws IOException {
        this.server = NettyServerBuilder.forAddress(this.socketAddress)
                .executor(Executors.newFixedThreadPool(5))
                .addService(new NbaStatsGrpcImpl())
                .build()
                .start();
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
