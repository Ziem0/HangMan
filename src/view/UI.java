package view;

import java.util.Scanner;
import controller.InputController;

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


}
