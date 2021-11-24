package com.another.leetcode.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class reconstruct_original_digits_from_english {
    public String originalDigits(String s) {
        Map<Character, Integer> data = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            data.put(c, data.getOrDefault(c, 0) + 1);
        }
        String[] str = {"zero", "six", "eight", "two", "seven", "three", "four", "five", "nine", "one"};
        char[] chr = {'z', 'x', 'g', 'w', 's', 'h', 'r', 'f', 'i', 'o'};
        int[] ints = {0, 6, 8, 2, 7, 3, 4, 5, 9, 1};

        for (int i = 0; i < chr.length; i++) {
            int t = data.getOrDefault(chr[i], 0);
            if (t == 0) continue;
            for (int j = 0; j < t; j++)
                answer.append(ints[i]);

            for (char tmp : str[i].toCharArray()) {
                data.put(tmp, data.get(tmp) - t);
            }

        }


        char[] result = answer.toString().toCharArray();
        Arrays.sort(result);
        return new String(result);

    }

    public static void main(String[] args) {
        System.out.println(new reconstruct_original_digits_from_english().originalDigits("owoztneoer"));
    }
}
