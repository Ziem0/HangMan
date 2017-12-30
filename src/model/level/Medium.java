package model.level;

import dao.DataReader;

public class Medium extends LevelZero {
    public Medium() {
        DataReader.addWordsByLevel("medium");
        words = DataReader.CAPITALS;
        word = getRandomWord();
        life = 6;
    }
}
