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

    public GameBoard getBoard() {
        return board;
    }
}
