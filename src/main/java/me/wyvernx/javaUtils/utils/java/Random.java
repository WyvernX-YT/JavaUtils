package me.wyvernx.javaUtils.utils.java;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;

public class Random {

    public int length;

    public Random(int length) {
        this.length = length - 1;
    }


    public int getRandNum() {
        return new java.util.Random().nextInt(999);
    }

    public String getRandomString() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i <= length; i++) {
            char c = alphabet[new java.util.Random().nextInt(alphabet.length)];
            str.append(c);
        }
        return str.toString();
    }
    public String getRandomStringU() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i <= length; i++) {
            int s = new java.util.Random().nextInt(1);
            char c='a';
            if(s == 0) {
                c = alphabet[new java.util.Random().nextInt(alphabet.length)];
            } else if (s == 1) {
                c = uppercase[new java.util.Random().nextInt(alphabet.length)];
            }
            str.append(c);
        }
        return str.toString();
    }

    //Sad Just Sad
    public int getRandomInt() {
        StringBuilder numberSequence = new StringBuilder();
        for(int i = 0; i<=length;i++) {
            int j = new java.util.Random().nextInt(9);
            numberSequence.append(j);
        }
        int i = 0;
        try {
            i = Integer.parseInt(numberSequence.toString());
        } catch(NumberFormatException e) {
            StringBuilder str = new StringBuilder();
            char[] c = numberSequence.toString().toCharArray();
            CharacterIterator iterator = new StringCharacterIterator(c.toString());
            int z = 0;
            ArrayList<String> ints = new ArrayList<>();
            for(int x = 1; x <= 9; x++) {
                ints.add(String.valueOf(x));
            }
            while(!ints.contains((String.valueOf(iterator.next())))) {
                z++;
                c[z] =' ';
                continue;
            }
            StringBuilder s = new StringBuilder();
            for(char cha : c) {
                s.append(c);
            }
            try {
                i = Integer.parseInt(s.toString().replaceAll(" ", ""));
            } catch (NumberFormatException ex) {
                i = Integer.MAX_VALUE;
            }
        }
        return i;
    }

    public String getRandomNumber() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i <= length; i++) {
            str.append(new java.util.Random().nextInt(9));
        }
        return str.toString();
    }

    public Long getRandomLong() {
        StringBuilder numberSequence = new StringBuilder();
        for(int i = 0; i<=length;i++) {
            int j = new java.util.Random().nextInt(9);
            numberSequence.append(j);
        }
        long i = 0;
        try {
            i = Long.parseLong(numberSequence.toString());
        } catch(NumberFormatException e) {
            StringBuilder str = new StringBuilder();
            char[] c = numberSequence.toString().toCharArray();
            CharacterIterator iterator = new StringCharacterIterator(c.toString());
            int z = 0;
            ArrayList<String> ints = new ArrayList<>();
            for(int x = 1; x <= 9; x++) {
                ints.add(String.valueOf(x));
            }
            while(!ints.contains((String.valueOf(iterator.next())))) {
                z++;
                c[z] =' ';
                continue;
            }
            StringBuilder s = new StringBuilder();
            for(char cha : c) {
                s.append(c);
            }
            try {
                i = Long.parseLong(s.toString().replaceAll(" ", ""));
            } catch (NumberFormatException ex) {
                i = Integer.MAX_VALUE;
            }
        }
        return i;
    }
}
