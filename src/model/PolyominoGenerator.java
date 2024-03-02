package model;

import java.util.*;

/**
 * This class generates random polyomino shapes for later fort placement within defined bounds.
 */

public class PolyominoGenerator {
    private final char rowStart = 'A';
    private final char rowEnd = 'J';
    private final int colStart = 1;
    private final int colEnd = 10;

    private enum Direction {
        UP(1, 0),
        RIGHT(0, 1),
        DOWN(-1, 0),
        LEFT(0, -1);

        private final int row;
        private final int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    public List<Cell> generateRandomPolyomino() {
        Random random = new Random();
        List<Cell> polyomino = new ArrayList<>();

        char startRow = (char) (rowStart + random.nextInt(rowEnd - rowStart + 1));
        int startCol = colStart + random.nextInt(colEnd - colStart + 1);

        Cell startCell = new Cell(startRow, startCol);
        polyomino.add(startCell);

        while (polyomino.size() < GameConfig.getNumberOfCells()) {
            Cell cell = polyomino.getLast();
            addAdjacentCell(polyomino, cell);
        }
        return polyomino;
    }

    private void addAdjacentCell(List<Cell> polyomino, Cell cell) {
        Random random = new Random();
        List<Cell> adjacentCells = new ArrayList<>();
        for (Direction dir : Direction.values()) {
            char newRow = (char) (cell.getRow() + dir.getRow());
            int newCol = cell.getCol() + dir.getCol();
            Cell adjacent = new Cell(newRow, newCol);
            if (isWithinBounds(adjacent) && !polyomino.contains(adjacent)) {
                adjacentCells.add(adjacent);
            }
        }
        if (!adjacentCells.isEmpty()) {
            polyomino.add(adjacentCells.get(random.nextInt(adjacentCells.size())));
        }
    }

    private boolean isWithinBounds(Cell cell) {
        return cell.getRow() >= rowStart &&
                cell.getRow() <= rowEnd &&
                cell.getCol() >= colStart &&
                cell.getCol() <= colEnd;
    }
}
