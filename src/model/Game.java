package model;

import java.util.List;

public class Game {
    private GameBoard board;
    private FortManager fortManager;

    public Game() {
        this.board = new GameBoard(GameConfig.getBoardSize());
        this.fortManager = new FortManager(board);

        fortManager.initializeForts(GameConfig.getNumberOfForts());
    }

    public boolean isValidCoordinate(String coordinate) {
        char rowChar = coordinate.charAt(0);
        int row = rowChar - 'A';
        int col;
        try {
            col = Integer.parseInt(coordinate.substring(1)) - 1;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return board.isWithinGrid(row, col);
    }

    public GameBoard getBoard() {
        return board;
    }
}
