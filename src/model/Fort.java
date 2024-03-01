package model;

import java.util.*;

public class Fort {
    private List<Cell> cells;
    private int numOfDamagedCells;
    PolyominoGenerator generator = new PolyominoGenerator();

    public Fort() {
        this.cells = generator.generateRandomPolyomino();
        this.numOfDamagedCells = 0;
    }

    public boolean isDestroyed() {
        int totalCells = GameConfig.getNumberOfCells();
        return numOfDamagedCells == totalCells;
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
