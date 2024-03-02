package model;

import java.util.*;

/**
 * The Fort class represents a fortress in the game, formed by 5 cells in Polyomino shape.
 * It keeps track of its status by keeping track of # damaged cells
 * Also has an id for identifier.
 */

public class Fort {
    private final List<Cell> cells;
    private char fortId;
    private int numOfDamagedCells;

    public Fort() {
        PolyominoGenerator generator = new PolyominoGenerator();
        this.cells = generator.generateRandomPolyomino();
        this.numOfDamagedCells = 0;
    }

    public boolean isDestroyed() {
        int totalCells = GameConfig.getNumberOfCells();
        return numOfDamagedCells >= totalCells;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getNumOfUndamagedCells() {
        int totalCells = GameConfig.getNumberOfCells();
        return totalCells - numOfDamagedCells;
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
