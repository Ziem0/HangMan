package view;

import java.util.Scanner;
import controller.InputController;
import jdk.internal.util.xml.impl.Input;

public class UI {
    static Scanner data = new Scanner(System.in);

    public static String userName() {
        String name = "";
        do {
            System.out.println("Type your name: ");
            name = data.next();
        } while (!InputController.nameIsValid(name));
        return name;
    }

    public static String userLevel() {
        String level = "";
        do {
            System.out.println("Choose level for your game:\n(1)easy\n(2)medium\n(3)hard: ");
            level = data.next();
        } while (!InputController.levelIsValid(level));
        return level;
    }

    public static void print(Object input) {
        System.out.println(input);
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String guessLetter() {
        String letter = "";
        do {
            print("Choose a letter: ");
            letter = data.next().toUpperCase();
        } while (!InputController.letterIsValid(letter));
        return letter;
    }

    public static String guessWord() {
        String word = "";
        do {
            print("Choose capital: ");
            word = data.next().toUpperCase();
        } while (!InputController.wordIsValid(word));
        return word;
    }


    public static String chooseWordOrLetter() {
        String action = "";
        do {
            print("You wanna guess word(1) or letter(2)? ");
            action = data.next();
        } while (!InputController.actionIsValid(action));
        return action;

    }
}
