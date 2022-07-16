package com.another.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class asteroid_collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> data = new Stack<>();

        for (int i = 0; i < asteroids.length; ) {
            if (data.size() == 0) {

                data.push(asteroids[i]);
                i++;
                continue;
            }

            int top = data.peek();
            if (top * asteroids[i] < 0) {

                top = Math.abs(top);
                asteroids[i] = Math.abs(asteroids[i]);
                if (top < asteroids[i]) {
                    data.pop();
                } else {
                    i++;
                }
            } else {
                data.push(asteroids[i]);
                i++;
            }
        }

        int[] result = new int[data.size()];
        int k = data.size()-1;
        while (!data.isEmpty()) {
            result[k--] = data.pop();

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new asteroid_collision().asteroidCollision(new int[]{5, 10, -5})));
    }
}
