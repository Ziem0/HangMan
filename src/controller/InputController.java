package controller;

public class InputController {

    public static boolean nameIsValid(String name) {
        return name.matches("[a-zA-Z]{3,}");
    }


}
