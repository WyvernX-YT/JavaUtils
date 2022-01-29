package me.wyvernx.javautils.utils.io;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {


    //printing
    public static String println(String input) {
        System.out.println(input);
        return input;
    }

    public static String[] println(String[] input) {
        for(String s : input) {
            System.out.println(s);
        }
        return input;
    }

    //printing
    public static Object println(Object input) {
        System.out.println(input);
        return input;
    }

    public static Object[] println(Object[] input) {
        for(Object s : input) {
            System.out.println(s);
        }
        return input;
    }
    public static ArrayList<Object> println(ArrayList<Object> input) {
        for(Object s : input) {
            System.out.println(s);
        }
        return input;
    }
    public static List <Object> println(List<Object> input) {
        for(Object s : input) {
            System.out.println(s);
        }
        return input;
    }

    //Errors
    public static String errorln(String input) {
        System.err.println(input);
        return input;
    }

    public static String[] errorln(String[] input) {
        for(String s : input) {
            System.err.println(s);
        }
        return input;
    }
    public static ArrayList<String> errorln(ArrayList<String> input) {
        for(String s : input) {
            System.err.println(s);
        }
        return input;
    }
    public static List <String> errorln(List<String> input) {
        for(String s : input) {
            System.err.println(s);
        }
        return input;
    }

    //Read lines
    @SneakyThrows
    public static String readLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

}
