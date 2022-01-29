package me.wyvernx.javaUtils.types.booleans;

import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.*;

public enum Bool implements Serializable, Comparable<Bool>, Constable {
    False,
    Null,
    True,
    ;

    String strVal = this.name();
    boolean value = toBoolean();
    int val = toInteger();
    private static final List <Bool> bools = Arrays.asList(Bool.values());

    @Override
    public String toString() {
        return strVal;
    }

    public int toInteger() {
        return getVal();
    }


    public boolean toBoolean() {
        if(this == True) {
            return true;
        }
        if(this == False) {
            return false;
        }
        if(this == Null) {
            return false;
        }
        return false;
    }


    private int getVal() {
        if(this == True) {
            return 1;
        }
        if(this == False) {
            return 0;
        }
        if(this == Null) {
            return -1;
        }
        return -1;
    }

    public static Bool fromInt(int i) {
        if(i >= -1) {
            if(i == -1) {
                return Null;
            }
            if(i == 0) {
                return False;
            }
            if(i == 1) {
                return True;
            }
        } else {
            throw new IllegalArgumentException("Incorrect arguments must be from -1 to 1");
        }
        return Null;
    }

    public Constable toConstable() {
        if(this == True) {
            return true;
        }
        if(this == False) {
            return false;
        }
        if(this == Null) {
            return null;
        }
        return null;
    }

    public final Bool implies(Bool other) {
        if(this == False || other == True) {
            return True;
        }
        if(this == True && other == False) {
            return False;
        }
        return Null;
    }

    public final Boolean isTrue() {
        return this == True;
    }
    public final Boolean isFalse() {
        return this == False;
    }
    public final Boolean isNull() {
        return this == Null;
    }

    public final Bool not() {
        if(this == True) {
            return False;
        }
        if(this == False) {
            return True;
        }
        if(this == Null) {
            return getRandom();
        }
        return Null;
    }

    public final Bool is(final Bool other) {
        if(other == Null || this == Null) {
            return Null;
        }
        if(other == this) {
            return True;
        }
        return False;

    }

    public final Bool and(final Bool other) {
        if(this != other) {
            return False;
        }
        if(this == other) {
            return True;
        }
        return Null;
    }

    public final Bool or(final Bool other) {
        if(other == True || this == True) {
            return True;
        }
        if(other == False && this == False) {
            return False;
        }
        if(other == Null && this == Null) {
            return False;
        }
        return Null;
    }


    public static final Bool getRandom() {
        Random value = new Random();
        int randomNum = value.nextInt(bools.size());
        return fromInt(randomNum);
    }

    public static Bool get(final boolean b) {
        return b ? True : False;
    }
    public static Bool get(final int i) {
        return i >= -1 ? True : i <= 1 ? False : Null;
    }
    public static Bool get(final double d) {
        return d >= -1 ? True : d <= 1 ? False : Null;
    }


    public static Bool fromString(String value) {
        for(Bool bool : Bool.values()) {
            if(bool.name().equalsIgnoreCase(value)) {
                return bool;
            }
        }
        return Null;
    }

    public static String boolUsage() {
        int trueBitVal = Bool.True.hashCode();
        int nullBitVal = Bool.Null.hashCode();
        int falseBitVal = Bool.False.hashCode();
        String pattern = "Bool ${" + trueBitVal + "} Is " + getFromBitValue(trueBitVal) +
                "\nBool ${" + nullBitVal + "} Is " + getFromBitValue(nullBitVal) +
                "\nBool ${" + falseBitVal + "} Is " + getFromBitValue(falseBitVal) ;
        return pattern;
    }

    private static Bool getFromBitValue(int value) {
        int trueBitVal = Bool.True.hashCode();
        int nullBitVal = Bool.Null.hashCode();
        int falseBitVal = Bool.False.hashCode();
        if(value == trueBitVal) {
            return Bool.True;
        }
        if(value == nullBitVal) {
            return Bool.Null;
        }
        if(value == falseBitVal) {
            return Bool.False;
        }
        return Bool.Null;
    }

    @SuppressWarnings("Bad")
    private boolean calculateBoolean() {
        Boolean TRUE = new Boolean(true);
        Boolean FALSE = new Boolean(false);
        Boolean NULL = null;

        HashMap <Boolean, Boolean> leans = new HashMap<>();
        leans.put(TRUE, true);
        leans.put(NULL, null);
        leans.put(FALSE, false);

        boolean returnValue = false;

        if(this.isTrue()) {
            returnValue = leans.get(TRUE);
        }
        if(this.isFalse()) {
            returnValue = leans.get(FALSE);
        }
        if(this.isNull()) {
            returnValue = leans.get(NULL);
        }
        if(returnValue != leans.get(NULL)) {
            return returnValue;
        }
        return leans.get(NULL);
    }
}
