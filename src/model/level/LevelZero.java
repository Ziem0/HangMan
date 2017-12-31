package model.level;

import view.UI;

import java.util.ArrayList;
import java.util.Random;

public abstract class LevelZero {
    public static ArrayList<String> words = new ArrayList<>();
    public static String word;
    public static Integer life;


    public Integer getLife() {
        return life;
    }

//    public String getWord() {
//        return word;
//    }

    public void setLife() {
        --life;
    }

    public static String getRandomWord() {
        int randomIndex = new Random().nextInt(words.size());
        return words.get(randomIndex);
    }

    public static String inputLevel() {
        String level = UI.userLevel();
        switch (level) {
            case "1":
                level = "easy";
                break;
            case "2":
                level = "medium";
                break;
            case "3":
                level = "hard";
                break;
        }
        return level;
    }
}
