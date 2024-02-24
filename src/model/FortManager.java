package model;

import java.util.ArrayList;
import java.util.List;

public class FortManager {
    private List<Fort> forts;
    private int points;

    public FortManager(int numOfForts) {
        forts = new ArrayList<>(numOfForts);
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void updatePoints() {
        //TODO
    }

    private int calculateDamagedForts(){
        int numOfDamagedForts = 0;
        for (Fort fort : forts){
            if (fort.isDestroyed()){
                numOfDamagedForts++;
            }
        }
        return numOfDamagedForts;
    }

    public boolean allFortsDestroyed(){
        return calculateDamagedForts() == forts.size();
    }
}
