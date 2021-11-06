package com.another.leetcode.math;

import java.util.Arrays;

public class missing_number {
    public int missingNumber(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        return (nums.length) * (nums.length + 1) / 2 - sum;
    }
}
