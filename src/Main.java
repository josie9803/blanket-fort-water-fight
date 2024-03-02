import model.Game;
import model.GameConfig;
import ui.TextUI;

/**
 * This Main class is the entry point for the game.
 * It parses command-line arguments and check validity for game customization.
 * It initializes the Game and invokes TextUI to display and handle user interactions.
 */

public class Main {
    public static void main(String[] args) {
        boolean isCheatMode = false;

        if (args.length > 2) {
            System.err.println("Error: accept up to 2 arguments.");
            return;
        }

        if (args.length > 0) {
            try {
                int numOfForts = Integer.parseInt(args[0]);
                GameConfig.setNumberOfForts(numOfForts);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number of forts. Using default.");
            }

            if (args.length == 2 && args[1].equals("--cheat")) {
                isCheatMode = true;
            }
        }

        try {
            Game game = new Game();
            TextUI ui = new TextUI(game);
            ui.show(isCheatMode);
        } catch (RuntimeException e) {
            System.err.printf("Error: Unable to place %s on the board.%n", args[0]);
            System.err.println("       Try running game again with fewer forts.");
        }
    }
}