package me.wyvernx.javautils.utils;

import java.io.Serializable;
import java.util.ArrayList;

public class ComplexList<K> extends ArrayList<K> implements Serializable {
    public int find(K toFind) {
        return this.indexOf(toFind);
    }
}
