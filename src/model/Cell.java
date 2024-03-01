package model;

public class Cell {
    private char row;
    private int col;
    private char cellId;
    private boolean isOccupied;
    private boolean isRevealed;
    private boolean isHit;

    public Cell(char row, int col) {
        this.row = row;
        this.col = col;
        this.isOccupied = false;
        this.isRevealed = false;
        this.isHit = false;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public void setCellId(char cellId) {
        this.cellId = cellId;
    }

    public char getCellId() {
        return cellId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return row == cell.row && col == cell.col;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", isOccupied=" + isOccupied +
                ", isRevealed=" + isRevealed +
                ", isHit=" + isHit +
                '}';
    }
}
