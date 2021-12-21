package com.another.leetcode.doublepointer;

import java.util.Arrays;

public class headters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0;
        int maxGap = -1;
        while (i < houses.length && j < heaters.length) {
            if (heaters[j] < houses[i]) {
                j++;
                continue;
            }


            if (j - 1 >= 0) {
                maxGap = Math.max(maxGap, Math.min(heaters[j] - houses[i], houses[i] - heaters[j - 1]));
            } else {
                maxGap = Math.max(maxGap, heaters[j] - houses[i]);
            }
            i++;

        }


        if (houses.length == i)
            return maxGap;

        maxGap = Math.max(maxGap, houses[houses.length - 1] - heaters[heaters.length - 1]);
        return maxGap;

    }

    public static void main(String[] args) {
        System.out.println(new headters().findRadius(new int[]{617819336, 399125485, 156091745, 356425228}
                , new int[]{585640194, 937186357}));
    }
}
