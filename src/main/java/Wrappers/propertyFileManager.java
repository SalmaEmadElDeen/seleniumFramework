package Wrappers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class propertyFileManager {
    private static File filePath = new File("config.properties");
    public static Properties prop = new Properties();
    public static String readPropertyFile(String Name)
    {
        String s;
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //load properties file
        try {
            prop.load(fileInput);
            s=prop.getProperty(Name);
            System.out.println(s);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
