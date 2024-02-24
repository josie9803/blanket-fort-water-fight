package model;

public class Game {
    private GameBoard board;

    public Game(String args) {
        this.board = new GameBoard(args);
    }

    public GameBoard getBoard() {
        return board;
    }
}
