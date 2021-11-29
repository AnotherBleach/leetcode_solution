package com.another.leetcode.priorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class k_th_smallest_prime_fraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        // 第u大的数
        int u = arr.length * (arr.length - 1) / 2 - k + 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double x1 = (double) (o1[0]) / o1[1];
                double x2 = (double) (o2[0]) / o2[1];

                return x1 - x2 > 0 ? 1 : -1;
            }
        });
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++) {
                if (queue.size() < u) {
                    queue.add(new int[]{arr[i], arr[j]});
                } else {
                    if (shouldReplace(queue.peek(), arr[i], arr[j])) {
                        queue.poll();
                        queue.add(new int[]{arr[i], arr[j]});
                    }
                }

            }

        return queue.peek();
    }

    private boolean shouldReplace(int[] peek, int i, int j) {
        double x1 = (double) (peek[0]) / peek[1];

        double x2 = (double) (i) / j;

        return x1 < x2;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new k_th_smallest_prime_fraction().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 1)));
    }
}
