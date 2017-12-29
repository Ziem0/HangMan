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



}
