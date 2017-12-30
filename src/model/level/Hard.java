package model.level;

import dao.DataReader;

public class Hard extends LevelZero {
    public Hard() {
        DataReader.addWordsByLevel("hard");
        words = DataReader.CAPITALS;
        word = getRandomWord();
        life = 3;
    }
}
