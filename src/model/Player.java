package model;

import view.UI;

public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
    }

    public static Player addPlayer() {
        String name = UI.userName();
        return new Player(name);
    }
}
