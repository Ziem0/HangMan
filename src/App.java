import model.Player;
import model.Hangman;
import model.level.*;
import controller.InputController;
import view.UI;

public class App {
    Player player;
    LevelZero level;
    Hangman hangman;

    private App(Player player, LevelZero level) {
        this.player = player;
        this.level = level;
        hangman = new Hangman(level);
    }

    private static LevelZero createLevel() {
        LevelZero level = null;
        String userLevel = LevelZero.inputLevel();
        switch (userLevel) {
            case "easy":
                level = new Easy();
                break;
            case "medium":
                level = new Medium();
                break;
            case "hard":
                level = new Hard();
                break;
        }
        return level;
    }

    public static void main(String[] args) {
        Player player = Player.addPlayer();
        LevelZero level = createLevel();
        App game = new App(player, level);

        System.out.println("Asd");
    }
}
