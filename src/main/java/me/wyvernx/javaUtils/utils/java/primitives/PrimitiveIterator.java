package me.wyvernx.javautils.utils.java.primitives;

import java.util.ArrayList;
import java.util.Iterator;

public class PrimitiveIterator implements Iterator <Primitive> {
    private final ArrayList <Primitive> pValue;
    private int pPosition;
    private int mFactorial;


    public PrimitiveIterator(ArrayList<Primitive> value) {
        this.pValue = value;
        this.pPosition = 1;
        this.mFactorial = 1;
    }

    @Override
    public boolean hasNext() {
        return pPosition <= pValue.size();
    }

    @Override
    public Primitive next() {
        if (!hasNext())
            return Primitive.NULL;

        mFactorial = mFactorial * pPosition;

        pPosition++;

        return pValue.get(pPosition);
    }
}
