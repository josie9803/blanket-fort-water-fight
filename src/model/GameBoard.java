package model;

public class GameBoard {
    public final int BOARD_SIZE = 10;
    private Cell[][] grid;
    private static FortManager opponents;

    public GameBoard(String arg) {
        this.grid = new Cell[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                char row = (char) ('A' + i);
                int col = j + 1;
                grid[i][j] = new Cell(row, col);
            }
        }
        opponents = new FortManager(Integer.parseInt(arg));
    }

}
