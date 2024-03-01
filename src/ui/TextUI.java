package ui;

import model.*;

import java.util.Scanner;

public class TextUI {
    private Game game;

    public TextUI(Game game) {
        this.game = game;
    }

    public void show(boolean isCheatMode) {
        if (isCheatMode) {
            displayBoard(true);
            System.out.println("(Lower case fort letters are where you shot.)");
        }
        displayTitle();

        while (!game.isEnd()) {
            displayBoard(false);
            getUserInput();
        }

        if (game.isUserWin()){
            System.out.println("Congratulations! You won!");
        }
        else{
            System.out.println("I'm sorry, your fort is all wet! They win!");
            //TODO: print out the result board
        }
    }

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move: ");
        String coordinate = scanner.nextLine().toUpperCase().trim();

        if (coordinate.isEmpty() || coordinate.contains(" ")|| !game.isValidCoordinate(coordinate)) {
            System.out.println("Invalid target. Please enter a coordinate such as D10.");
            getUserInput();
        } else {
            updateBoardAfterUserMove(coordinate.charAt(0),coordinate.charAt(1));
        }
    }

    public void updateBoardAfterUserMove(char row, char col){
        boolean isHit = game.hasShootAtCell(row, col);
        if (isHit) {
            System.out.println("HIT!");
        } else {
            System.out.println("Miss.");
        }

        int[] scoreList = game.getAllOpponentsScoreList();
        for (int i = 0; i < scoreList.length; i++){
            System.out.println("Opponent #" + i + " of " + GameConfig.getNumberOfForts()
            + " shot you for " + scoreList[i] + " points!");
        }

        game.updateOpponentTotalScore();
    }

    public void displayBoard(boolean isCheatMode) {
        GameBoard board = game.getBoard();
        Cell[][] grid = board.getGrid();
        System.out.println("\nGame Board:");
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
        System.out.printf("Opponents points: " + game.getOpponentTotalScore() + " / %d.%n", 2500);
    }

    private void displayTitle() {
        System.out.printf("\nStarting game with %d forts.%n", GameConfig.getNumberOfForts());
        System.out.println("------------------------");
        System.out.println("Welcome to Fort Defense!\nby Josie and Nathan");
        System.out.println("------------------------");
    }

    private String getDisplayChar(Cell cell, boolean isCheatMode) {
        if (!isCheatMode) {
            if (!cell.isRevealed()) {
                return "  ~";
            }
            else{
                if (cell.isHit()){
                    return "  X";
                }
                else{
                    return "   ";
                }
            }
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
