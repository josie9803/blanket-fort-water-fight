package model;

/**
 * The Game class handles the main logic of the game
 * It provides methods for player to shoot, updating the scores, and checking win conditions.
 */

public class Game {
    private final GameBoard board;
    private final FortManager fortManager;
    private int opponentTotalScore = 0;
    private static final int MAXIMUM_SCORE_OF_OPPONENT = 2500;

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

    public int getOpponentTotalScore() {
        return opponentTotalScore;
    }

    public int[] getAllOpponentsScoreList() {
        int[] scoreList = new int[fortManager.getAliveForts().size()];
        int i = 0;

        for (Fort fort : fortManager.getAliveForts()) {
            int numOfUndamagedCells = fort.getNumOfUndamagedCells();
            int opponentScore = switch (numOfUndamagedCells) {
                case 5, 4 -> 20;
                case 3 -> 5;
                case 2 -> 2;
                case 1 -> 1;
                default -> 0;
            };
            scoreList[i++] = opponentScore;
        }

        return scoreList;
    }

    public void updateOpponentTotalScore() {
        for (int j : getAllOpponentsScoreList()) {
            opponentTotalScore += j;
        }
    }

    public boolean hasShootAtCell(char row, int col) {
        int convertedRow = row - 'A';
        int convertedCol = col - 1;
        Cell cell = board.getGrid()[convertedRow][convertedCol];
        cell.setRevealed(true);
        if (cell.isOccupied()) {
            updateCellStatus(cell);
            return true;
        }
        return false;
    }

    private void updateCellStatus(Cell cell) {
        cell.setHit(true);
        fortManager.getForts().stream()
                .filter(fort -> cell.getCellId() == fort.getFortId())
                .forEach(Fort::increaseNumOfDamagedCellsByOne);
    }
    public boolean isEnd(){
        return opponentTotalScore >= MAXIMUM_SCORE_OF_OPPONENT
                || fortManager.allFortsDestroyed();
    }

    public boolean isUserWin() {
        if (isEnd()) {
            return fortManager.allFortsDestroyed();
        }
        return false;
    }
}
