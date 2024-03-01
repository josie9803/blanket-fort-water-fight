package ui;

import model.*;

public class TextUI {
    private Game game;

    public TextUI(Game game) {
        this.game = game;
    }

    public void displayBoard(boolean isCheatMode) {
        GameBoard board = game.getBoard();
        Cell[][] grid = board.getGrid();
        System.out.println("Game Board:");
        System.out.println("       1  2  3  4  5  6  7  8  9 10");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("    " + (char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                Cell cell = grid[i][j];
                String displayChar = getDisplayChar(cell, isCheatMode);
                System.out.print(displayChar);
            }
            System.out.println();
        }
        System.out.printf("Opponents points: 0 / %d.%n", 2500);
        System.out.println("(Lower case fort letters are where you shot.)");
    }

    private String getDisplayChar(Cell cell, boolean isCheatMode) {
        if (!isCheatMode) {
            return "  ~";
        } else {
            if (!cell.isOccupied()) {
                return "  .";
            } else if (cell.isHit()) {
                return "  X";
            } else {
                return "  " + cell.getCellId();
            }
        }
    }
}
