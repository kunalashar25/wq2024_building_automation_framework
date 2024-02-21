package com.ttt.wq.manager.file.reader;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import com.ttt.wq.utils.LogHelper;

public class PropertyReader implements IReader {

    private String basePath = "src/main/resources/";
    private String configPath = basePath + "config.properties";
    private String environmentPath = basePath + "environments/";
    private String secretsPath = basePath + "secrets/";

    private static Properties properties = new Properties();

    public PropertyReader() {
        read(configPath);

        String env = getProperty("runEnvironment") + ".properties";
        read(environmentPath + env);
        read(secretsPath + env);
    }

    @Override
    public void read(String filePath) {
        LogHelper.getLogger().info("Reading {} file", filePath);
        File file = new File(filePath);

        try (FileReader reader = new FileReader(file)) {
            properties.load(reader);
        } catch (Exception e) {
            LogHelper.getLogger().error("Error while reading the file", e);
            System.exit(0);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        new PropertyReader();
        System.out.println(PropertyReader.getProperty("baseUrl"));
    }
}
