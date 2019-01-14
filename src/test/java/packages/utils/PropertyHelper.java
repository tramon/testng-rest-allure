package packages.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHelper {

    public static String getProperty(String propertyName) {
        Properties prop = new Properties();

        try (InputStream propertyFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(String.format("environments/%s.properties", getEnvironment()))){
            prop.load(propertyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(propertyName);
    }

    private static String getEnvironment() {
        String environment = System.getProperty("env");
        if (environment == null) {
            return "qa";
        } else {
            return environment;
        }
    }
}
