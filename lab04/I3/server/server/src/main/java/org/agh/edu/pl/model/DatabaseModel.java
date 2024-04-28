package org.agh.edu.pl.model;


import com.zeroc.Ice.Current;
import org.agh.edu.pl.actions.Database;

public class DatabaseModel implements Database {

    private final int servantID;

    public DatabaseModel(int servantID) {
        this.servantID = servantID;
        System.out.println("Created Database servant with id: " + servantID);
    }

    @Override
    public void toUpperCaseAndSave(String info, Current current) {
        System.out.println(
                "ObjectID: " + current.id +
                        " servantID: " + this.servantID +
                        " called toUpperCaseAndSave" +
                        " info: " + info.toUpperCase()
        );
    }
}

