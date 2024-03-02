package model;

/**
 * This class represents the game board with a 2-dimensional grid of cells.
 * It provides methods for checking a given position validity and accessing the current grid.
 */

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

    public boolean isWithinGrid(int row, int col) {
        return row >= 0 && row < GameConfig.getBoardSize() && col >= 0 && col < GameConfig.getBoardSize();
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
