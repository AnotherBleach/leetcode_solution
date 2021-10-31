package com.another.leetcode.bit.java;

import java.util.Arrays;

/**
 * 只出现一次的数字 III
 * 题目链接： https://leetcode-cn.com/problems/single-number-iii/
 */
public class single_number_iii {
    public int[] singleNumber(int[] nums) {

        int sum = 0;
        //1、全部异或，最后只会留下两个不同数的异或值，因为其余的数两两相同，全部异或成0了
        for (int i : nums) sum ^= i;


        //2、在sum中随便找到一个不为0的位置
        int k = -1;
        for (int i = 31; i >= 0; i--) {
            if (((sum >> i) & 1) == 1) {
                k = i;
                break;
            }
        }


        //3、第k位不为0，说明两个不同的数中，第k为互不相同，把第k为为0，1的数弄开分别异或，就可以把两个数分开
        int[] result = new int[2];
        for (int i : nums) {

            if (((i >> k) & 1) == 1) {
                result[1] ^= i;
            } else {
                result[0] ^= i;
            }
        }
        //返回答案
        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new single_number_iii().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
