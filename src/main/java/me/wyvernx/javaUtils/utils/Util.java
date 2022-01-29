package me.wyvernx.javaUtils.utils;

import me.wyvernx.javaUtils.types.booleans.Bool;
import me.wyvernx.javaUtils.types.integers.LargeInt;
import me.wyvernx.javaUtils.types.strings.SingleChar;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Util {
    public static String[] toStringArray(String... s) {
        return s;
    }
    public static int[] toIntArray(int... i) {
        return i;
    }
    public static char[] toCharArray(char... c) {
        return c;
    }
    public static byte[] toByteArray(byte... b) {
        return b;
    }
    public static boolean[] toBooleanArray(boolean... b) {
        return b;
    }
    public static double[] toDoubleArray(double... d) {
        return d;
    }
    public static float[] toFloatArray(float... f) {
        return f;
    }
    public static SingleChar[] toSingleCharArray(SingleChar... s) {
        return s;
    }
    public static Bool[] toBoolArray(Bool... b) {
        return b;
    }

    public static boolean isSimilar(int i, int j) {
        return i + 3 == j || i + 1 == j || i == j || i + 2 == j || i - 1 == j || i - 2 == j || i - 3 == j;
    }



    public static boolean not(Boolean b) {
        return b = !b;
    }
    public static boolean and(Boolean a, Boolean b) {
        if(a == b) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean or(Boolean a, Boolean b) {
        if(a == true || b == true) {
            return true;
        }
        return false;
    }

    public static double[] circle(int time) {
        double x;
        double y;
        double t = time;
        x = java.lang.Math.sin(t);
        y = java.lang.Math.cos(t);
        double[] list = {x, y};
        return list;
    }

    public static boolean stringToBoolean(String s) {
        if(s.equalsIgnoreCase("true") || s.equalsIgnoreCase("t"))
            return true;
        else if(s.equalsIgnoreCase("false") || s.equalsIgnoreCase("f"))
            return false;
        else {
            throw new IllegalArgumentException("Incorrect input string does not give a valid value");
        }
    }
    public static boolean intToBoolean(int i) {
        if(i >= 1)
            return true;
        else if(i >= 0)
            return false;
        return false;
    }
    public static boolean floatToBoolean(float f) {
        if(f >= 1.0f)
            return true;
        else if(f < 1.0f)
            return false;
        return false;
    }
    public static boolean doubleToBoolean(double d) {
        if(d >= 1.0D)
            return true;
        else if(d < 1.0D)
            return false;
        return false;
    }
    public static boolean longToBoolean(long l) {
        if(l >= 1L)
            return true;
        else if(l <= 0L)
            return false;
        return false;
    }
    public static boolean largeIntToBoolean(LargeInt i) {
        if(i.isGreater(1))
            return true;
        return false;
    }


    public static Number toNumber(boolean b) {
        int i = 0;
        if(b) {
            i = 1;
        }
        if(!b) {
            i = 0;
        }
        int finalI = i;
        Number n = new Number() {
            @Override
            public int intValue() {
                return finalI;
            }

            @Override
            public long longValue() {
                return finalI;
            }

            @Override
            public float floatValue() {
                return finalI;
            }

            @Override
            public double doubleValue() {
                return finalI;
            }
        };
        return n;
    }


    public static int random(int min, int max) {
        return new Random().nextInt(min,max);
    }

    public static String encrypt(String message, String key){

        StringBuilder encryptedMessage = new StringBuilder();
        char ch;
        int j = 0;


        for(int i = 0; i < message.length(); i++, j++){

            if(j >= key.length())
                j = 0;

            ch = message.charAt(i);

            ch = (char) ((key.charAt(j) ^ ch));

            encryptedMessage.append(ch);

        }

        return encryptedMessage.toString();
    }

    public static String sCharToString(SingleChar... chars) {
        List <SingleChar> c = Arrays.asList(chars);
        StringBuilder builder = new StringBuilder();
        c.forEach(builder :: append);
        return builder.toString();
    }

    public static String progressBar(long startTime, long total, long current) {
        long eta = current == 0 ? 0 :
                (total - current) * (System.currentTimeMillis() - startTime) / current;

        String etaHms = current == 0 ? "N/A" :
                String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(eta),
                        TimeUnit.MILLISECONDS.toMinutes(eta) % TimeUnit.HOURS.toMinutes(1),
                        TimeUnit.MILLISECONDS.toSeconds(eta) % TimeUnit.MINUTES.toSeconds(1));

        StringBuilder string = new StringBuilder(140);
        int percent = (int) (current * 100 / total);
        if(percent >= 100) {
            percent = 100;
        }
        if(current >= total) {
            current = total;
        }
        string
                .append('\r').append("\r")
                .append(String.join("", Collections.nCopies(percent == 0 ? 2 : 2 - (int) (Math.log10(percent)), " ")))
                .append(String.format(" %d%% [", percent))
                .append(String.join("", Collections.nCopies(percent, "=")))
                .append('>')
                .append(String.join("", Collections.nCopies(100 - percent, " ")))
                .append(']')
                .append(String.join("", Collections.nCopies((int) (Math.log10(total)) - (int) (Math.log10(current)), " ")))
                .append(String.format(" %d/%d, ETA: %s", current, total, etaHms));

        return string.toString();
    }
}

