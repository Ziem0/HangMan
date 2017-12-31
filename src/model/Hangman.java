package model;

import model.level.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Hangman {
    public ArrayList<String> usedLetters = new ArrayList<>();
    public String word;
    public Integer life;

    public Hangman(LevelZero level) {
        this.word = word;
        this.life = life;
    }

    public String dashes() {
        String used = getUsedLettersInStringForm();
        Pattern p = Pattern.compile("[^ '" + used + "]", Pattern.CASE_INSENSITIVE);
        return p.matcher(this.word).replaceAll("-");
    }

    private String getUsedLettersInStringForm() {
        return String.join("", this.usedLetters);
    }

}
