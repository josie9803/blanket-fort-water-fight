import model.Game;
import model.GameConfig;
import ui.TextUI;

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

        Game game = new Game();
        TextUI ui = new TextUI(game);
        ui.show(isCheatMode);
    }
}