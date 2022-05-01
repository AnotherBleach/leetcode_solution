package com.another.contest;

import java.math.BigInteger;
import java.util.Arrays;

public class SolutionC {
    public int maximumCandies(int[] candies, long k) {

        BigInteger total = BigInteger.ZERO;
        for (int i = 0; i < candies.length; i++) {
            total = total.add(new BigInteger(candies[i] + ""));
        }

        BigInteger big_k = new BigInteger(k + "");
        if (total.compareTo(big_k) < 0) return 0;

        Arrays.sort(candies);

        int avg = total.divide(big_k).intValue();

        while (true) {

            int size = 0;
            for (int j = candies.length - 1; j >= 0; j--) {
                size = size+candies[j]/avg;
                if (size>=k) break;

            }
            if (size>=k) break;
            avg = avg-1;
            if (avg == 0) break;
        }


        return avg;
    }

    public static void main(String[] args) {
          }
}
