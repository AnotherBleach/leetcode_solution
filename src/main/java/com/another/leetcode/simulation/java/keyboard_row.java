package com.another.leetcode.simulation.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class keyboard_row {
    int[][] dict = new int[3][26];

    {
        String d = "qwertyuiop";
        for (int i = 0; i < d.length(); i++) {
            dict[0][d.charAt(i) - 'a'] = 1;
        }

        d = "asdfghjkl";
        for (int i = 0; i < d.length(); i++) {
            dict[1][d.charAt(i) - 'a'] = 1;
        }

        d = "zxcvbnm";
        for (int i = 0; i < d.length(); i++) {
            dict[2][d.charAt(i) - 'a'] = 1;
        }
    }

    public String[] findWords(String[] words) {


        List<String> collect = Arrays.stream(words).filter(this::inDict).collect(Collectors.toList());

        String[] result = new String[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            result[i] = collect.get(i);
        }
        return result;
    }

    private boolean inDict(String x) {
        x = x.toLowerCase();
        char[] c = x.toCharArray();
        boolean find = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < c.length; j++) {
                if (dict[i][c[j] - 'a'] == 0) break;
                if (j == c.length - 1) {
                    find = true;
                    break;
                }
            }
            if (find)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new keyboard_row().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
