package com.another.leetcode.simulation.java;

public class bulls_and_cows {
    public String getHint(String secret, String guess) {
        int[] data = new int[10];
        int[] data1 = new int[10];

        int len = secret.length();
        int A = 0;
        int B = 0;

        char[] sec = secret.toCharArray();
        char[] gus = guess.toCharArray();

        for (int i = 0; i < len; i++) {
            if (sec[i] == gus[i]) {
                A++;
            } else {
                data[sec[i] - '0']++;
                data1[gus[i] - '0']++;
            }
        }
        StringBuilder sb = new StringBuilder();

        if (A == len)
            return sb.append(A).append("A").append(0).append("B").toString();


        B = 0;

        for (int i = 0; i < 10; i++) {
            if (data[i] != 0 && data1[i] != 0)
                B += Math.min(data[i], data1[i]);
        }


        return sb.append(A).append("A").append(B).append("B").toString();
    }

    public static void main(String[] args) {
        System.out.println(new bulls_and_cows().getHint("1123",
                "0111"));
    }
}
