package com.ttt.wq.manager.file.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader implements IReader {

    private String basePath = "src/main/resources/";
    private String configPath = basePath + "config.properties";

    private static Properties properties = new Properties();

    public PropertyReader() {
        read(configPath);
    }

    @Override
    public void read(String filePath) {
        File file = new File(filePath);

        try (FileReader reader = new FileReader(file)) {
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        PropertyReader reader = new PropertyReader();
        System.out.println(reader.getProperty("baseUrl"));
    }
}