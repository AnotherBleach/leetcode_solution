package com.another.leetcode.normal;

public class fuckingeasy {
    final int constant = 1 + 2 + 3 + 4 + 5 + 6 + 7;

    public int totalMoney(int n) {
        if (n <= 7) return (1 + n) * n / 2;
        int x = n / 7;
        int y = n % 7;
      return constant * x + 7 * ((x) * (x - 1)) / 2 + ((x + 1) +(x + y)) * y / 2;

    }

    public static void main(String[] args) {
        System.out.println(new fuckingeasy().totalMoney(10));
    }
}
