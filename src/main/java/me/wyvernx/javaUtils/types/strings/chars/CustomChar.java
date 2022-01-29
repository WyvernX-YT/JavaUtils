package me.wyvernx.javautils.types.strings.chars;

import java.util.HashMap;

public class CustomChar {
    int value;
    String str;

    private static final HashMap<Integer, String> chars = new HashMap <>();


    public CustomChar(String ch, int value) {
        this.value = value;
        this.str = ch;
        if(this.value > 274 + chars.size()) {
            chars.put(value, ch);
        } else {
            throw new IllegalArgumentException("Value must be higher than " + 274 + chars.size());
        }
    }

    public static HashMap<Integer, String> getCharMap() {
        return (HashMap <Integer, String>)chars.clone();
    }

    public static String getChar(int i) {
        return chars.get(i);
    }

}
