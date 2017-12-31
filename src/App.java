import model.Player;
import model.Hangman;
import model.level.*;
import controller.InputController;
import view.UI;

public class App {
    private Player player;
    private Hangman hangman;
    private LevelZero level;

    private App(Player player, LevelZero level) {
        this.player = player;
        this.level = level;
        this.hangman = new Hangman(this.level);
    }

    public static void main(String[] args) {

    }
}
