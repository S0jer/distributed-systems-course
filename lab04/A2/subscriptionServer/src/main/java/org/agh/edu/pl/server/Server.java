package org.agh.edu.pl.server;

import io.grpc.netty.NettyServerBuilder;
import org.agh.edu.pl.model.NbaPlayer;
import org.agh.edu.pl.service.NbaStatisticsThreadManager;
import org.agh.edu.pl.service.NbaStatsGrpcImpl;
import org.agh.edu.pl.service.NotificationsThreadManager;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.Executors;

public class Server {
    private final int port = 50051;
    private final String address = "127.0.0.1";
    private io.grpc.Server server;
    private NbaStatisticsThreadManager nbaStatisticsThreadManager;
    private NotificationsThreadManager notificationsThreadManager;
    private final SocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName(address), port);

    public Server() throws UnknownHostException {
    }

    public void start() throws IOException {
        List<NbaPlayer> nbaPlayers = List.of(
                new NbaPlayer(1, List.of("2020/2021", "2021/2022")),
                new NbaPlayer(2, List.of("2021/2022")),
                new NbaPlayer(3, List.of("2018/2019", "2019/2020", "2020/2021", "2021/2022")),
                new NbaPlayer(4, List.of("2022/2023", "2023/2024")),
                new NbaPlayer(5, List.of("2002/2003", "2004/2005", "2005/2007"))
        );

        NbaStatsGrpcImpl nbaStatsGrpcImpl = new NbaStatsGrpcImpl(nbaPlayers);
        nbaStatisticsThreadManager = new NbaStatisticsThreadManager(nbaPlayers);
        nbaStatisticsThreadManager.start();
        notificationsThreadManager = new NotificationsThreadManager(nbaPlayers);
        notificationsThreadManager.start();


        this.server = NettyServerBuilder.forAddress(this.socketAddress)
                .executor(Executors.newFixedThreadPool(12))
                .addService(nbaStatsGrpcImpl)
                .build()
                .start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                Server.this.stop();
                System.err.println("server shut down");
            }
        });
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
        nbaStatisticsThreadManager.interrupt();
        notificationsThreadManager.interrupt();

    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
