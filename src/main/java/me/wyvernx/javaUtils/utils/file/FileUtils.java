package me.wyvernx.javautils.utils.file;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings( {"ignored"})
public class FileUtils {

    public static File createFile(String path) {
        File file = new File(path);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();

                return null;
            }
        }
        return file;
    }


    public static ArrayList<String> readLines(File file) {
        List <String> lines;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return (ArrayList <String>)lines;
    }
    public static ArrayList<String> readLines(String path) {
        List <String> lines;
        try {
            lines = Files.readAllLines(Path.of(new URI(path)));
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return (ArrayList <String>)lines;
    }

    public static String write(File file, String... toWrite) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(file));
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
        for(String string : toWrite) {
            try {
                writer.write(string);
            } catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return Arrays.toString(toWrite);
    }

}
