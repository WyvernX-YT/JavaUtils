package me.wyvernx.javaUtils.utils.java;

import org.jetbrains.annotations.Nullable;

public enum Type {
    String(null, java.lang.String.class),
    Integer("int", java.lang.Integer.class),
    Boolean("boolean", java.lang.Boolean.class),
    Bool(null, me.wyvernx.javaUtils.types.booleans.Bool.class),
    Char("char", Character.class),
    SingleChar(null, me.wyvernx.javaUtils.types.strings.SingleChar.class),
    Long("long", java.lang.Long.class),
    Float("float", java.lang.Float.class),
    Double("double", java.lang.Double.class),
    BigInteger(null, java.math.BigInteger.class),
    LargeInt(null, me.wyvernx.javaUtils.types.integers.LargeInt.class),
    Byte("byte", java.lang.Byte.class),
    BigDecimal(null, java.math.BigDecimal.class)
    ;

    String primitiveType;
    Class type;

    Type(@Nullable String primitiveType, Class type) {
        this.type = type;
        if (primitiveType == null) this.primitiveType = "None";
        this.primitiveType = primitiveType;

    }

    public String getPrimitiveType() {
        return this.primitiveType;
    }

    public static String getPrimitiveType(Type type) {
        return type.getPrimitiveType();
    }

    public String getName() {
        return this.name();
    }

    public static String getName(Type type) {
        return type.getName();
    }


    public Class getType() {
        return this.type;
    }

    public static Class getType(Type type) {
        return type.getType();
    }

}
