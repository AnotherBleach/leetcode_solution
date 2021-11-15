package com.another.leetcode.dp;

/**
 * 思路：第一个特殊处理，第一个要么选，要么不选
 */
public class rob_ii {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);


        //选择第一个，那么第二个、最后一个不能选，剩余元素和rob1解法一样
        // a b c d e f
        // x x       x
        int[] useHead = new int[nums.length - 3];
        if (useHead.length > 1) {

            useHead[useHead.length - 1] = nums[nums.length - 2];
            useHead[useHead.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 3]);
            for (int j = useHead.length - 3; j >= 0; j--) {
                useHead[j] = Math.max(nums[j + 2] + useHead[j + 2], useHead[j + 1]);
            }

        } else if (useHead.length == 1) {

            useHead[0] = nums[2];
        } else {
            useHead = new int[1];
            useHead[0] = 0;
        }

        //a b c d e f
        //x

        //不选第一个，就和以第二个元素开头的rob1是一样的解法
        int[] notUseHead = new int[nums.length - 1];
        notUseHead[notUseHead.length - 1] = nums[nums.length - 1];
        notUseHead[notUseHead.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
        for (int j = notUseHead.length - 3; j >= 0; j--) {
            notUseHead[j] = Math.max(nums[j + 1] + notUseHead[j + 2], notUseHead[j + 1]);
        }
        return Math.max(notUseHead[0], nums[0] + useHead[0]);


    }
}
