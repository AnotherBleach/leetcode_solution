package com.another.leetcode.binarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class xuan_zhuan {

    public int minArray(int[] nums) {


        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r && nums[0] == nums[r]) r--;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) l = mid + 1;
            else r = mid - 1;
        }
        return r + 1 < n ? nums[r + 1] : nums[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("a good   example".split(" ")));
        String[] data = "a good   example".split("\\s+");
        for (int i = 0; i < data.length; i++) {
            System.out.println("#" + data[i] + "#");
        }
    }

    public boolean isStraight(int[] nums) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if (num != 0) {
                if (treeMap.containsKey(num)) return false;
                else treeMap.put(num, 1);
            }
        }
        int minKey = treeMap.firstKey();
        int maxKey = treeMap.lastKey();
        return maxKey-minKey<5;
    }
}
