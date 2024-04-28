package org.agh.edu.pl.model;

import com.zeroc.Ice.Current;
import org.agh.edu.pl.actions.Subtractor;

public class SubtractorModel implements Subtractor {

    private final int servantID;

    public SubtractorModel(int servantID) {
        this.servantID = servantID;
        System.out.println("Created Subtractor servant with id: " + servantID);
    }

    @Override
    public int subtract(int fundamental, int retracent, Current current) {
        System.out.println(
                "ObjectID: " + current.id +
                        " servantID: " + this.servantID +
                        " called subtract" +
                        " result: " + (fundamental - retracent)
        );
        return fundamental - retracent;
    }
}
