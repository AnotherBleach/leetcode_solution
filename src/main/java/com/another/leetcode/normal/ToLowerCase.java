package com.another.leetcode.normal;

public class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char[] data = s.toCharArray();

        for (int i = 0; i < len; i++) {
            if (data[i] >= 'A' && data[i] <= 'Z') {
                sb.append((char)(data[i] + 32));
            } else {
                sb.append(data[i]);
            }
        }
        return sb.toString();
    }
}
