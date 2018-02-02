package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyProvider {

    private static Properties properties = new Properties();
    private static String propertyFilePath = "src\\main\\resources\\config.properties";



    private static void loadProperty(){

        File file = new File(propertyFilePath);
        if(!file.isDirectory()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String propertyName) {
        loadProperty();
        String value;
        if( (System.getProperty(propertyName)) != null){

            value = System.getProperty(propertyName);
        }
        else {
            value = PropertyProvider.properties.getProperty(propertyName);
        }
        return value;
    }


}
