import dao.DataReader;
import model.Player;
import model.Hangman;
import model.level.*;
import controller.InputController;
import view.UI;

public class App {
    private static boolean isCheat = true;
    private static String ANSWER;
    private boolean isContinue = true;
    private Player player;
    private LevelZero level;
    private Hangman hangman;

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

    private void gameLoop() {
        UI.clear();
        showCheat();
        UI.print("Used letters: " + hangman.niceFormForUsedLetters());
        UI.print("you have "+ hangman.life + " life");
        UI.print(hangman.dashes());
        getTip();
        chooseAction();
        checkStatus();
    }

    private void showCheat() {
        if (isCheat) {
            UI.print(hangman.word);
        }
    }

    private void checkStatus() {
        if (hangman.life.equals(0)) {
            lostGame();
        } else if (InputController.finalAnswer(hangman.word, ANSWER)) {
            winGame();
        } else if (!hangman.dashes().contains("-")) {
            winGame();
        }
    }

    private void winGame() {
        UI.print("Hey " + player.getName() + "! You won this game!\nYou're master of programming xd");
        this.isContinue = false;
    }

    private void lostGame() {
        UI.print("Hey " + player.getName() + "! You lost this game!\nYou're dead man xd");
        this.isContinue = false;
    }

    private void getTip() {
        if (hangman.life < 2) {
            String country = DataReader.BOX.get(hangman.word);
            UI.print("This is a capital of " + country);
        }
    }

    private void chooseLetter() {
        String letter = "";
        letter = UI.guessLetter();
        hangman.addLetterToUsedLetter(letter);
        if (hangman.word.contains(letter)) {
            UI.print("That's correct!");
        } else {
            hangman.decreaseLife();
            UI.print("That's not correct!");
        }
    }

    private void chooseWord() {
        ANSWER = UI.guessWord();
        if (!ANSWER.equals(hangman.word)) {
            hangman.decreaseLife();
            UI.print("That's not correct!");
        }
    }

    private void chooseAction() {
        String action = UI.chooseWordOrLetter();
        if (action.equals("1")) {
            chooseWord();
        } else {
            chooseLetter();
        }
    }



    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("cheat")) {
            isCheat = true;
        }

        UI.clear();
        Player player = Player.addPlayer();
        LevelZero level = createLevel();
        App game = new App(player, level);
        while (game.isContinue) {
            game.gameLoop();
        }
        System.exit(0);
    }
}
