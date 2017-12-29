package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class DataReader {
    static ArrayList<String> CAPITALS = new ArrayList<>();
    static TreeMap<String, String> BOX = new TreeMap<>();

    /**
     * Read data from file and add capitals to CAPITALS and add countries as a key and capitals as an value in BOX
     * @param fileName csv file
     */
    private static void Reader(String fileName) {
        FileReader fr = null;
        BufferedReader bfr;
        String line = "";

        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Invalid file");
        }
        bfr = new BufferedReader(fr);

        try {
            while ((line = bfr.readLine()) != null) {
                List<String> lineList = Arrays.asList(line.split(","));
                BOX.put(lineList.get(0), lineList.get(1));
                CAPITALS.add(lineList.get(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Choose the range of data depending on the level
     * @param level string; user choice
     * @see DataReader#Reader
     */
    public static void addWordsByLevel(String level) {
        String europe = "src/resources/europe.csv";
        String americas = "src/resources/americas.csv";
        String africa = "src/resources/africa.csv";

        switch (level) {
            case "easy":
                break;
            case "medium":
                Reader(americas);
                break;
            case "hard":
                Reader(americas);
                Reader(africa);
                break;
        }
        Reader(europe);
    }
}
