package com.another.leetcode.math;

/**
 * https://leetcode-cn.com/problems/range-addition-ii/
 */
public class range_addition_ii {
    public int maxCount(int m, int n, int[][] ops) {

        int minX = m, minY = n;
        for (int[] a : ops) {
            if (a[0] < minX) minX = a[0];
            if (a[1] < minY) minY = a[1];
        }
        return minY * minX;

    }
}
