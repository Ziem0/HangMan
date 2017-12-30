package model.level;

import dao.DataReader;

public class Easy extends LevelZero {
    public Easy() {
        DataReader.addWordsByLevel("easy");
        words = DataReader.CAPITALS;
        word = getRandomWord();
        life = 10;
    }
}
