package model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The FortManager class manages all Forts' placement and status in the game:
 * The class utilizes the GameBoard to strategically place and track forts.
 * It provides methods for initializing, checking, and retrieving the forts.
 */

public class FortManager {
    private final List<Fort> forts = new ArrayList<>();
    private final GameBoard board;
    private char currentCellId = 'A';

    public FortManager(GameBoard board) {
        this.board = board;
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
            fort.setFortId(currentCellId);
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
            if (!board.isWithinGrid(actualRow, actualCol) || grid[actualRow][actualCol].isOccupied()) {
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
            if (board.isWithinGrid(actualRow, actualCol)) {
                Cell boardCell = board.getGrid()[actualRow][actualCol];
                boardCell.setCellId(id);
                boardCell.setOccupied(true);
            }
        }
    }

    public List<Fort> getForts() {
        return forts;
    }

    public List<Fort> getAliveForts() {
        return forts.stream()
                .filter(fort -> !fort.isDestroyed())
                .collect(Collectors.toList());
    }

    private int calculateDamagedForts() {
        return (int) forts.stream()
                .filter(Fort::isDestroyed)
                .count();
    }

    public boolean allFortsDestroyed() {
        return calculateDamagedForts() == forts.size();
    }
}
