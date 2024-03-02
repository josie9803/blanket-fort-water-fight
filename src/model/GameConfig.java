package model;

/**
 * GameConfig class manages the game configuration settings.
 * It provides methods for initializing, accessing and modifying these values:
 * # of forts, # of cells, and board size.
 * The class follows singleton pattern for global configuration throughout the game by using
 * static methods and fields.
 */

public class GameConfig {
    private static int numberOfForts = 5;
    private static int numberOfCells = 5;
    private static int boardSize = 10;

    public static int getNumberOfForts() {
        return numberOfForts;
    }

    public static int getNumberOfCells() {
        return numberOfCells;
    }

    public static int getBoardSize() {
        return boardSize;
    }

    public static void setNumberOfForts(int numberOfForts) {
        GameConfig.numberOfForts = numberOfForts;
    }
}
