package helpers;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVReaderClass {

    public static String getFirstValueFromCSV(String filename) throws IOException {

        String value = "" ;
        CSVReader csvReader = null;
        int first_value = 0;

        try {
            csvReader = new CSVReader(new FileReader(filename));
            String[] row = csvReader.readNext();
            value = row[first_value];
        }
        catch (Exception e){

        }
        finally {

        }

        return value;
    }


    public static String getSecondValueFromCSV(String filename) throws IOException {

        String value = "" ;
        CSVReader csvReader = null;
        int second_value = 1;

        try {
            csvReader = new CSVReader(new FileReader(filename));
            String[] row = csvReader.readNext();
            value = row[second_value];

        }
        catch (Exception e) {

        }
        finally {
            csvReader.close();
        }

        return value;
    }
}
