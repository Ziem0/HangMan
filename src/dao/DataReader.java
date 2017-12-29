package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class DataReader {
    ArrayList<String> CAPITALS = new ArrayList<>();
    TreeMap<String, String> BOX = new TreeMap<>();

    /**
     * Read data from file and add capitals to CAPITALS and add countries as a key and capitals as an value in BOX
     * @param fileName csv file
     */
    private void Reader(String fileName) {
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



}
