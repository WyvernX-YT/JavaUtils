package me.wyvernx.javautils.utils.format;

import me.wyvernx.javautils.utils.Util;
import org.apache.commons.text.StringSubstitutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Format {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static final Map <String, String> vMap = new HashMap <>();


    public static String format(String toFormat) {
        StringSubstitutor sub = new StringSubstitutor(vMap);
        return sub.replace(toFormat);
    }
    public static String format(ArrayList<String> toFormat) {
        StringSubstitutor sub = new StringSubstitutor(vMap);
        StringBuilder f = new StringBuilder();
        for(String s : toFormat) {
            f.append(s).append("\n");
        }
        return sub.replace(f.toString());
    }




    //placeholders
    static {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();


        vMap.put("time", dtf.format(now));

        //properties
        vMap.put("username", System.getProperty("user.name"));
        vMap.put("0", "" + System.currentTimeMillis());
        vMap.put("home", "" + System.getProperty("user.home"));
        vMap.put("random", "" +Util.random(-2147483647, 2147483647));

        //colors
        vMap.put("white", ANSI_WHITE);
        vMap.put("black", ANSI_BLACK);
        vMap.put("color_reset", ANSI_RESET);
        vMap.put("red", ANSI_RED);
        vMap.put("green", ANSI_GREEN);
        vMap.put("yellow", ANSI_YELLOW);
        vMap.put("blue", ANSI_BLUE);
        vMap.put("purple", ANSI_PURPLE);
        vMap.put("cyan", ANSI_CYAN);

        //Bool values
        vMap.put("1104106489", "True");
        vMap.put("94438417", "Null");
        vMap.put("787604730", "False");


        //Helpful
        vMap.put("nl", "\n");
        vMap.put("rf", "\r");


    }
}
