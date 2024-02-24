package model;

import java.util.ArrayList;
import java.util.List;

public class Fort {
    public final int TOTAL_CELLS = 5;
    private List<Cell> cells = new ArrayList<>();
    private int numOfDamagedCells;

    public Fort(List<Cell> cells) {
        this.cells = cells;
        this.numOfDamagedCells = 0;
    }
    public boolean isDestroyed(){
        return numOfDamagedCells == TOTAL_CELLS;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getNumOfDamagedCells() {
        return numOfDamagedCells;
    }

    public void updateNumOfDamagedCells() {
        this.numOfDamagedCells++;
    }
}
