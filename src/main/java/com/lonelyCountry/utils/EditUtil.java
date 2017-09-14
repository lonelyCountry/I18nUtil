package com.lonelyCountry.utils;

import java.io.File;
import java.io.IOException;

public class EditUtil {

    public static void writeFirst(StringBuilder... arr) throws Exception {
        for (StringBuilder sb : arr) {
            sb.append(System.getProperty("line.separator"));
        }
    }

    public static String getSpace(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i++ < size) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static File createOrGetFile(String path) throws IOException {
        File root = new File(path.substring(0, path.lastIndexOf(File.separator)));
        if (!root.exists()) {
            root.mkdirs();
        }
        File file = new File(root, path.substring(path.lastIndexOf(File.separator) + 1));
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
