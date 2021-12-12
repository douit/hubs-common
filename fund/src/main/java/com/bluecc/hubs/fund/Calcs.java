package com.bluecc.hubs.fund;

import java.math.BigDecimal;
import java.util.List;

public final class Calcs {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static BigDecimal sumDecimal(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }


    /** Compute the sample (unbiased estimator) standard deviation following:
     *
     *  Computing Deviations: Standard Accuracy
     *  Tony F. Chan and John Gregg Lewis
     *  Stanford University
     *  Communications of ACM September 1979 of Volume 22 the ACM Number 9
     *
     *  The "two-pass" method from the paper; supposed to have better
     *  numerical properties than the textbook summation/sqrt.  To me
     *  this looks like the textbook method, but I ain't no numerical
     *  methods guy.
     */
    public static double stddev(int[] X) {
        int m = X.length;
        if ( m<=1 ) {
            return 0;
        }
        double xbar = avg(X);
        double s2 = 0.0;
        for (int i=0; i<m; i++){
            s2 += (X[i] - xbar)*(X[i] - xbar);
        }
        s2 = s2/(m-1);
        return Math.sqrt(s2);
    }

    /** Compute the sample mean */
    public static double avg(int[] X) {
        double xbar = 0.0;
        int m = X.length;
        if ( m==0 ) {
            return 0;
        }
        for (int i=0; i<m; i++){
            xbar += X[i];
        }
        if ( xbar>=0.0 ) {
            return xbar / m;
        }
        return 0.0;
    }

    public static int min(int[] X) {
        int min = Integer.MAX_VALUE;
        int m = X.length;
        if ( m==0 ) {
            return 0;
        }
        for (int i=0; i<m; i++){
            if ( X[i] < min ) {
                min = X[i];
            }
        }
        return min;
    }

    public static int max(int[] X) {
        int max = Integer.MIN_VALUE;
        int m = X.length;
        if ( m==0 ) {
            return 0;
        }
        for (int i=0; i<m; i++){
            if ( X[i] > max ) {
                max = X[i];
            }
        }
        return max;
    }

    /** Compute the sample mean */
    public static double avg(List<Integer> X) {
        double xbar = 0.0;
        int m = X.size();
        if ( m==0 ) {
            return 0;
        }
        for (int i=0; i<m; i++){
            xbar += X.get(i);
        }
        if ( xbar>=0.0 ) {
            return xbar / m;
        }
        return 0.0;
    }

    public static int min(List<Integer> X) {
        int min = Integer.MAX_VALUE;
        int m = X.size();
        if ( m==0 ) {
            return 0;
        }
        for (int i=0; i<m; i++){
            if ( X.get(i) < min ) {
                min = X.get(i);
            }
        }
        return min;
    }

    public static int max(List<Integer> X) {
        int max = Integer.MIN_VALUE;
        int m = X.size();
        if ( m==0 ) {
            return 0;
        }
        for (int i=0; i<m; i++){
            if ( X.get(i) > max ) {
                max = X.get(i);
            }
        }
        return max;
    }

    public static int sum(int[] X) {
        int s = 0;
        int m = X.length;
        if ( m==0 ) {
            return 0;
        }
        for (int i=0; i<m; i++){
            s += X[i];
        }
        return s;
    }
}
