package me.wyvernx.javaUtils.types.strings;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.lang.constant.Constable;
import java.lang.constant.ConstantDesc;
import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.stream.IntStream;

public class SingleChar implements CharSequence, Serializable, Constable, Comparable<SingleChar> {

    byte[] bytes;

    char[] charStorage;


    public static final int minLength = 0;
    public static final int maxLength = 1;


    private final int length;

    private final int[] binaryValues;

    private final byte[] value;

    private String str;

    public SingleChar(String singleChar) {
        this.value = singleChar.getBytes();
        this.length = singleChar.length();
        if(length >= minLength && length <= maxLength) {

        } else {
            throw new IllegalArgumentException("Too long");
        }
        str = singleChar;
        this.bytes = str.getBytes();
        this.charStorage = (char[]) str.toCharArray();
        this.binaryValues = str.chars().toArray();

    }
    public SingleChar(Character singleChar) {
        this.value = singleChar.toString().getBytes();
        this.length = singleChar.toString().length();
        if(length >= minLength && length <= maxLength) {

        } else {
            throw new IllegalArgumentException("Too long");
        }
        str = singleChar.toString();
        this.bytes = str.getBytes();
        this.charStorage = (char[]) str.toCharArray();
        this.binaryValues = str.chars().toArray();

    }
    public SingleChar(int ch) {
        this.value = String.valueOf(ch).getBytes();
        this.length = String.valueOf(ch).length();
        if(length >= minLength && length <= maxLength) {

        } else {
            throw new IllegalArgumentException("Too long");
        }
        str = String.valueOf((char) ch);
        this.bytes = str.getBytes();
        this.charStorage = (char[]) str.toCharArray();
        this.binaryValues = str.chars().toArray();

    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int index) {
        return str.charAt(index);
    }

    @Override
    public boolean isEmpty() {
        return str.isEmpty();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return str.subSequence(start,end);
    }

    @NotNull
    @Override
    public String toString() {
        return  this.getClass().getName() + ";" + bytes.toString() + ":" + charStorage + "[" + value + "]" + "{" + length + "" + str.intern().getBytes().toString() ;
    }

    @Override
    public IntStream chars() {
        return str.chars();
    }

    @Override
    public IntStream codePoints() {
        return str.codePoints();
    }

    @Override
    public Optional <? extends ConstantDesc> describeConstable() {
        return str.describeConstable();
    }


    public Object resolveConstantDesc(MethodHandles.Lookup lookup) throws ReflectiveOperationException {
        return str.resolveConstantDesc(lookup);
    }

    @Override
    public int compareTo(@NotNull SingleChar o) {
        return new SingleChar(str).compareTo(o);
    }

    public String stringValue() {
        return str;
    }

    public String getBinary() {
        return printBinary(binaryValues);
    }

    private String printBinary(int[] binary) {

        StringBuilder result = new StringBuilder();
        for (int i = 31;i >= 0;i--) {
            int mask = 1 << i;
            for(int j = 0; j < binary.length; j++) {
                result.append((binary[j] & mask) != 0? "1": "0");
            }
        }
        return result.toString();
    }
}
