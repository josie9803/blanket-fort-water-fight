import model.Game;
import model.GameBoard;
import ui.TextUI;

public class Main {
    public static void main(String[] args) {
//        Game game = new Game();
        TextUI ui = new TextUI(args[0]);
        ui.displayBoard();
    }
}