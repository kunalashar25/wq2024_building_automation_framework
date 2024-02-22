package com.ttt.wq.manager.directory;

import java.io.File;
import com.ttt.wq.utils.LogHelper;

public class Directory {

    public static void clean(String... names) {
        for (String dir : names) {
            LogHelper.getLogger().warn("Cleaning Directory {}", dir);
            File cleanDir = new File(dir);
            removeFiles(cleanDir);
        }
    }

    private static void removeFiles(File dir) {
        File[] files = dir.listFiles();

        if (dir.exists()) { // throws error when folder/file doesn't exist
            for (File file : files) {
                if (file.isDirectory()) {
                    removeFiles(file);
                    file.delete(); // deletes sub folders
                } else
                    file.delete(); // deletes internal files
            }

            dir.delete(); // deletes parent folder
        }
    }

    public static void main(String[] args) {
        clean("output");
    }
}
