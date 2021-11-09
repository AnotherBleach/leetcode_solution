package com.another.leetcode.stack;

import java.util.Stack;

public class daily_temperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] data = new int[temperatures.length];

        if (temperatures.length == 1) return data;

        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures.length - 1);

        for (int j = temperatures.length - 2; j >= 0; j--) {

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[j]) {
                    stack.pop();
                }

            }
            if (!stack.isEmpty()) {
                data[j] = stack.peek() - j;
            }
            stack.push(j);
        }
        return data;
    }
}
