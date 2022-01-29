package me.wyvernx.javautils.utils.java.primitives;

import lombok.Getter;
import me.wyvernx.javautils.utils.java.Type;

import java.util.ArrayList;

public enum Primitive {
    INT("int", 0, Integer.class, Type.Integer),
    CHAR("char", 5, Character.class, Type.Char),
    BOOLEAN("boolean", 4, Boolean.class, Type.Boolean),
    LONG("long", 1, Long.class, Type.Long),
    DOUBLE("double", 2, Double.class, Type.Double),
    FLOAT("float", 3, Float.class, Type.Float),
    BYTE("byte", 6, Byte.class, Type.Byte),
    NULL("null", 7),
    ;

    public static ArrayList<Primitive> types = new ArrayList <>();

    @Getter
    public String type;
    @Getter
    public int integer;
    @Getter
    public Class clazz;
    @Getter
    public Type value;


    Primitive(String type) {
        this.type = type;
    }
    Primitive(String type, int integer) {
        this.type = type;
        this.integer = integer;
    }
    Primitive(String type, int integer, Class clazz) {
        this.type = type;
        this.integer = integer;
        this.clazz = clazz;
    }
    Primitive(String type, int integer, Class clazz, Type value) {
        this.type = type;
        this.integer = integer;
        this.clazz = clazz;
        this.value = value;
    }

    static {
        types.add(INT);
        types.add(CHAR);
        types.add(BOOLEAN);
        types.add(LONG);
        types.add(DOUBLE);
        types.add(FLOAT);
        types.add(BYTE);
    }
}


