package com.another.leetcode.normal;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class maximize_sum_of_array_after_k_negations {
    public int largestSumAfterKNegations(int[] nums, int k) {

        Integer[] integerArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArr, Comparator.comparingInt(Math::abs));

        for (int i = nums.length - 1; i >= 0; i--) {
            if (k == 0) break;
            if (integerArr[i] < 0) {
                integerArr[i] = -integerArr[i];
                k--;
            }
        }

        if (k % 2 == 1) {
            integerArr[0] = -integerArr[0];
        }
        int sum = 0;
        for (int i : integerArr) sum += i;
        return sum;


    }

    public static void main(String[] args) {
        System.out.println(new maximize_sum_of_array_after_k_negations().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}
