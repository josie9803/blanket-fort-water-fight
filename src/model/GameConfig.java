package model;

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
