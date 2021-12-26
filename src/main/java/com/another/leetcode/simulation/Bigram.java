package com.another.leetcode.simulation;

public class Bigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] data = text.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length - 2; i++) {
            if (first.hashCode() == data[i].hashCode() && second.hashCode() == data[i + 1].hashCode()) {
                sb.append(data[i + 2]).append(" ");
            }
        }
        return sb.toString().split(" ");
    }
}
