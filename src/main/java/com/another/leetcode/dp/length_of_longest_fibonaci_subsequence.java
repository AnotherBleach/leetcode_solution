package com.another.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class length_of_longest_fibonaci_subsequence {

    public int lenLongestFibSubseq(int[] arr) {
        int[][] f = new int[arr.length][arr.length];
        Map<Integer/*val*/, Integer/*pos*/> indexMap = new HashMap<>();
        for (int p = 0; p < arr.length; p++) {
            indexMap.put(arr[p], p);
        }

        int maxVal = 0;
        for (int j = arr.length - 2; j >= 0; j--)
            for (int i = j - 1; i >= 0; i--) {
                int targetVal = arr[i] + arr[j];
                int targetPos = indexMap.getOrDefault(targetVal,-1);
                if(targetPos!=-1){
                    f[i][j]=Math.max(3,f[j][targetPos]+1);
                    if(f[i][j]>maxVal)maxVal=f[i][j];
                }

            }



        return maxVal;
    }

    public static void main(String[] args) {
        System.out.println(new length_of_longest_fibonaci_subsequence().lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }

}
