package me.wyvernx.javautils.utils;

public class Mathf {
    public static float mutate(float toMutate) {
        float f = toMutate;
        float mMulti;
        float mSubtractor;
        float mAddition;
        float mDivision;

        double[] mutation = new double[] {
                36.5, 84.8, 75.1, 67.0, 0.1, 1.8, 180,
                256.0, 32.0, 82.6, 75.6, 87.9, 39.9,
                80.0, 82.8, 0.001, 0.002, 0.84, 81.2,
                45.4, 42.1, 49.5, 85.2, 0.1, 0.6
        };

        mMulti = (float)(mutation[Util.random(0, mutation.length)] * mutation[Util.random(0, mutation.length)]);
        mAddition = (float)(mutation[Util.random(0, mutation.length)] + mutation[Util.random(0, mutation.length)]);
        mSubtractor = (float)(mutation[Util.random(0, mutation.length)] - mutation[Util.random(0, mutation.length)]);
        mDivision = (float)((float)(mutation[Util.random(0, mutation.length)]) / (mutation[Util.random(0, mutation.length)]));

        f = f * mMulti + mAddition - mSubtractor / mDivision;


        toMutate = f;

        return f;
    }
    public static long factorial(long n) {
        if      (n <  0) throw new RuntimeException("Underflow error in factorial");
        else if (n > 20) throw new RuntimeException("Overflow error in factorial");
        else if (n == 0) return 1;
        else             return n * factorial(n-1);
    }

    public static double sin(double d) {
        double x = d;
        x = x % (2 * Math.PI);

        // compute the Taylor series approximation
        double term = 1.0;      // ith term = x^i / i!
        double sum  = 0.0;      // sum of first i terms in taylor series

        for (int i = 1; term != 0.0; i++) {
            term *= (x / i);
            if (i % 4 == 1) sum += term;
            if (i % 4 == 3) sum -= term;
        }
        return sum;
    }
}

