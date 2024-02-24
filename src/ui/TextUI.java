package ui;

import model.Game;

public class TextUI {
    Game game;

    public TextUI(String args) {
        this.game = new Game(args);
    }

    public void displayBoard() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < game.getBoard().BOARD_SIZE; i++) {
            System.out.print((char)('A' + i) + " ");
            for (int j = 0; j < game.getBoard().BOARD_SIZE; j++) {
                System.out.print("i");
            }
            System.out.println();
        }
    }
}
