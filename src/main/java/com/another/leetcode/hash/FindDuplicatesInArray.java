package com.another.leetcode.hash;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {


            if (nums[i] == 0) {
                i++;
            } else if (nums[i] - 1 != i) {

                int tmp = nums[nums[i] - 1];
                if (tmp == nums[i]) {
                    data.add(tmp);
                    nums[i] = 0;
                } else {
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                }

            } else {
                i++;
            }

        }

        return data;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicatesInArray().findDuplicates(new int[]{1}));
    }
}
