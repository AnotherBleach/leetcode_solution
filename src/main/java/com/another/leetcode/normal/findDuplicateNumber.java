package com.another.leetcode.normal;

public class findDuplicateNumber {

    // 2 <= n <= 100000
    public int findRepeatNumber(int[] nums) {
        /**
         * 原地置换
         */
        for (int i = 0; i < nums.length; i++) {

            if(nums[i]==i)continue;

            if (nums[nums[i]] == nums[i])
                return nums[i];

            while (nums[i] != i) {

                if(nums[i]==nums[nums[i]])return nums[i];
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;

            }


        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new findDuplicateNumber().findRepeatNumber(new int[]{3,4,2,0,0,1}));
    }
}
