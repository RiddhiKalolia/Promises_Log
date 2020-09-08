package util;

import java.io.IOException;
import java.util.Properties;

public class ProgramDataProvider {
    private static final Properties programData = new Properties();

    static {
        try {
            programData.load(ProgramDataProvider.class.getClassLoader().getResourceAsStream("data\\program-data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProgramData(String propertyName) {
        try {
            return programData.getProperty(propertyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
