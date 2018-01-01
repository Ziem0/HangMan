package controller;

import model.Hangman;

public class InputController {

    public static boolean nameIsValid(String name) {
        return name.matches("[a-zA-Z]{3,}");
    }

    public static boolean levelIsValid(String level) {
        return level.matches("[1-3]");
    }

    public static boolean letterIsValid(String letter) {
        return letter.matches("[A-Z]{1}");
    }

    public static boolean actionIsValid(String action) {
        return action.matches("[1-2]{1}");
    }

    public static boolean wordIsValid(String word) {
        return word.matches("[A-Z]{1,}");
    }

    public static boolean finalAnswer(String capital, String answer) {
        return capital.equals(answer);
    }
}
