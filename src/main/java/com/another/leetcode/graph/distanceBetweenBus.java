package com.another.leetcode.graph;

import java.util.Arrays;

public class distanceBetweenBus {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int totalSum = Arrays.stream(distance).sum();

        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }

        int max = 0;
        for (int i = start; i < destination; i++) {
            max += distance[i];
        }
        return Math.min(max, totalSum - max);

    }
}
