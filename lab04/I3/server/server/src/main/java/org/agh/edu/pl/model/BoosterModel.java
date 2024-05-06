package org.agh.edu.pl.model;

import com.zeroc.Ice.Current;
import org.agh.edu.pl.actions.Booster;

public class BoosterModel implements Booster {

    private final int servantID;
    private int sum = 0;

    public BoosterModel(int servantID) {
        this.servantID = servantID;
        System.out.println("Created Booster servant with id: " + servantID);
    }

    @Override
    public int boostAndReturn(int number, Current current) {
        sum += number;
        System.out.println(
                "ObjectID: " + current.id +
                        " servantID: " + this.servantID +
                        " called booster" +
                        " result: " + sum
        );
        return sum;
    }
}
