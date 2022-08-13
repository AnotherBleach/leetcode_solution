package com.another.leetcode.simulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class aaaaa {
    public int maxChunksToSorted(int[] arr) {
        int[] maxThanMe = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            maxThanMe[i] = i;

        for (int i = arr.length - 1; i >= 0; i--) {
            int maxPos = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    if (maxPos == -1) maxPos = j;
                    else if (arr[j] <= arr[maxPos]) maxPos = j;

                }

            }
            if (maxPos != -1) maxThanMe[i] = maxPos;
        }

        int[] result = new int[arr.length];
        int val = 1;

        for (int i = arr.length - 1; i >= 0; i--) {


            //i=i-(i-maxThanMe[i]+1);
            for (int j = i; j >= maxThanMe[i]; j--) {
                if (result[i] != 0) {
                    result[j] = result[i];
                } else {
                    result[j] = val;
                }
            }
            val++;


        }

        Set<Integer> data = new HashSet<>();
        for (int i = 0; i < result.length; i++) {
            data.add(result[i]);
        }
        return data.size();

    }

    public static void main(String[] args) {
        int[]data = new int[2000];
        Random rd = new Random();
        for(int i=0;i<data.length;i++){
            data[i]=rd.nextInt(100);
        }
        System.out.println(Arrays.toString(data));
        System.out.println(new aaaaa().maxChunksToSorted(data));
    }
}
