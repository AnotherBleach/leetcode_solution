package com.another.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            return x[1] - y[1];
        });

        int begin = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {

            int[] cur = intervals[i];
            if (cur[1] > end) {

                if (cur[0] > end) {

                    int[] tmp = new int[2];
                    tmp[0] = begin;
                    tmp[1] = end;
                    result.add(tmp);
                    begin = cur[0];
                    end = cur[1];
                } else end = cur[1];

            }

        }
        if (begin != -1) {
            int[] tmp = new int[2];
            tmp[0] = begin;
            tmp[1] = end;
            result.add(tmp);
        }
        int[][] data = new int[result.size()][2];
        result.toArray(data);
        return data;


    }
}
