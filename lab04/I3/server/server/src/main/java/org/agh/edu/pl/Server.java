package org.agh.edu.pl;


import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import org.agh.edu.pl.model.BoosterModel;
import org.agh.edu.pl.model.SubtractorModel;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {
            // Create an object adapter with specific endpoints
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z");

            // Singleton for Booster: holds state and is frequently used
            BoosterModel booster = new BoosterModel(1);
            adapter.add(booster, Util.stringToIdentity("booster"));

            // Lazy instantiation for Database: holds state and is infrequently used
            DBServantLocator dbServantLocator = new DBServantLocator();
            adapter.addServantLocator(dbServantLocator, "database");

            // Shared servant for Subtractor: stateless and used frequently
            SubtractorModel subtractor = new SubtractorModel(2);
            adapter.addDefaultServant(subtractor, "subtractor");

            // Activate the adapter and enter the processing loop
            adapter.activate();
            System.out.println("Server is running...");
            communicator.waitForShutdown();
        }
    }
}

