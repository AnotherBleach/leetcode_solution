package com.another.leetcode.dp;

public class frogGame {
}

class Solution {
    final int constant = 1000000007;

    public int numWays(int n) {
        return f(n);
    }

    public int f(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] data = new int[n + 1];

        data[0] = data[1] = 1;
        data[2] = 2;
        for (int i = 3; i <= n; i++) {
            data[i] = (data[i - 1] % constant + data[i - 2] % constant) % constant;
        }
        return data[n];

    }
}