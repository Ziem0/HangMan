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
        this.word = level.word;
        this.life = level.life;
    }

    public String dashes() {
        String used = getUsedLettersInStringForm();
        Pattern p = Pattern.compile("[^ '" + used + "]", Pattern.CASE_INSENSITIVE);
        return p.matcher(this.word).replaceAll("-");
    }

    private String getUsedLettersInStringForm() {
        return String.join("", this.usedLetters);
    }

    public String niceFormForUsedLetters() {
        this.usedLetters.sort(String::compareToIgnoreCase);
        return String.join(", ", usedLetters);
    }

    public void addLetterToUsedLetter(String letter) {
        this.usedLetters.add(letter.toUpperCase());
    }

    public Integer decreaseLife() {
        --this.life;
        return this.life;
    }
}
