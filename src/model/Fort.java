package model;

import java.util.*;

public class Fort {
    private List<Cell> cells;
    private char fortId;
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

    public int getNumOfUndamagedCells() {
        int NUM_OF_CELLS = 5;
        return NUM_OF_CELLS - numOfDamagedCells;
    }

    public void setFortId(char fortId) {
        this.fortId = fortId;
    }

    public char getFortId() {
        return fortId;
    }

    public void increaseNumOfDamagedCellsByOne() {
        this.numOfDamagedCells++;
    }
}
