package model;

public class GameBoard {
    private Cell[][] grid;

    public GameBoard(int boardSize) {
        this.grid = new Cell[boardSize][boardSize];
        initializeGrid(boardSize);
    }

    private void initializeGrid(int boardSize) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                char row = (char) ('A' + i);
                int col = j + 1;
                grid[i][j] = new Cell(row, col);
            }
        }
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
