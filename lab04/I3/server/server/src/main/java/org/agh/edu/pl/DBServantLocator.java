package org.agh.edu.pl;


import com.zeroc.Ice.Current;
import com.zeroc.Ice.Object;
import com.zeroc.Ice.ServantLocator;
import org.agh.edu.pl.model.DatabaseModel;


public class DBServantLocator implements ServantLocator {
    private int currentID = 1;

    @Override
    public LocateResult locate(Current curr) {
        DatabaseModel databaseModel = new DatabaseModel(currentID++);
        System.out.println("Locating and instantiating DatabaseObject with ID: " + (currentID - 1));
        return new ServantLocator.LocateResult(databaseModel, null);
    }

    @Override
    public void finished(Current curr, Object servant, java.lang.Object cookie) {
        // Optional: actions to perform after a request is processed
    }

    @Override
    public void deactivate(String category) {
        // Actions to perform on deactivation, if any
    }
}
