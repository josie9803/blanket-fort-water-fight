package model;

import java.util.*;

public class FortManager {
    private List<Fort> forts = new ArrayList<>();
    private GameBoard board;
    private char currentCellId = 'A';
    private int points;

    public FortManager(GameBoard board) {
        this.board = board;
        this.points = 0;
    }

    public void initializeForts(int numberOfForts) {
        for (int i = 0; i < numberOfForts; i++) {
            boolean isPlaced = false;
            for (int attempt = 0; attempt < 100 && !isPlaced; attempt++) {
                Fort newFort = new Fort();
                isPlaced = hasPlacedFort(newFort);
            }
            if (!isPlaced) {
                throw new RuntimeException("Could not place all forts.");
            }
        }
    }

    private boolean hasPlacedFort(Fort fort) {
        Random random = new Random();
        int boardSize = GameConfig.getBoardSize();

        int startRow = random.nextInt(boardSize);
        int startCol = random.nextInt(boardSize);

        if (canPlaceFortAt(fort, startRow, startCol)) {
            forts.add(fort);
            markFortOnBoard(fort, startRow, startCol, currentCellId);
            currentCellId = (char) (currentCellId + 1);
            return true;
        }
        return false;
    }

    private boolean canPlaceFortAt(Fort fort, int startRow, int startCol) {
        for (Cell fortCell : fort.getCells()) {
            int actualRow = startRow + (fortCell.getRow() - 'A');
            int actualCol = startCol + (fortCell.getCol() - 1);

            Cell[][] grid = board.getGrid();
            if (!isWithinBounds(actualRow, actualCol) || grid[actualRow][actualCol].isOccupied()) {
                return false;
            }
        }
        return true;
    }

    private void markFortOnBoard(Fort fort, int startRow, int startCol, char id) {
        List<Cell> cells = fort.getCells();
        for (Cell cell : cells) {
            int actualRow = startRow + (cell.getRow() - 'A');
            int actualCol = startCol + (cell.getCol() - 1);
            if (isWithinBounds(actualRow, actualCol)) {
                Cell boardCell = board.getGrid()[actualRow][actualCol];
                boardCell.setCellId(id);
                boardCell.setOccupied(true);
            }
        }
    }

    private boolean isWithinBounds(int row, int col) {
        return row >= 0 && row < GameConfig.getBoardSize() && col >= 0 && col < GameConfig.getBoardSize();
    }

    public int getFortSize() {
        return forts.size();
    }

    public List<Fort> getForts() {
        return forts;
    }

    public int getPoints() {
        return points;
    }

    public void updatePoints() {
        //TODO
    }

    private int calculateDamagedForts() {
        int numOfDamagedForts = 0;
        for (Fort fort : forts) {
            if (fort.isDestroyed()) {
                numOfDamagedForts++;
            }
        }
        return numOfDamagedForts;
    }

    public boolean allFortsDestroyed() {
        return calculateDamagedForts() == forts.size();
    }
}
