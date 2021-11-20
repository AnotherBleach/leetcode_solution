package com.another.leetcode.normal;

import java.util.HashMap;
import java.util.Map;

public class longest_harmonious_subsequence {
    public int findLHS(int[] nums) {

        Map<Integer, Integer> data = new HashMap<>();
        for (int x : nums) {
            data.put(x, data.getOrDefault(x, 0) + 1);
        }
        int small = 0, big = 0;
        int maxLength = 0;
        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {

            int key = entry.getKey();
            int valueSmall = entry.getValue();
            if (data.get(key + 1) == null) continue;
            int valueBig = data.get(key + 1);
            if (valueSmall + valueBig > maxLength) {
                maxLength = valueBig + valueSmall;
                small = key;
                big = key + 1;
            }

        }
        return small == big ? 0 : data.get(small) + data.get(big);

    }
}
