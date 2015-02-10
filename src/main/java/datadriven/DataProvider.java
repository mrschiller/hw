package datadriven;

import base.ConfigReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProvider {

    private String csvFile = ConfigReader.getValueByKey("csvFile");
    private BufferedReader br = null;
    private String line = "\n";
    private String cvsSplitBy = ",";
    private Map<Integer, String[]> data = new HashMap<Integer, String[]>();

    public DataProvider() {
        try {
            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] actions = line.split(cvsSplitBy);
                data.put(i++, actions);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map<Integer, String[]> getData(){
        return data;
    }
}