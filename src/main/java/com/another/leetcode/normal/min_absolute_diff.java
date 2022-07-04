package com.another.leetcode.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class min_absolute_diff {
}
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>>result = new ArrayList<>();
        int min=1000000;

        for(int i=0;i<arr.length-1;i++){
            int cur = arr[i];
            int next = arr[i+1];
            int gap = next-cur;
            if(gap<min){
                result.clear();
                List<Integer>data = Arrays.asList(cur,next);
                result.add(data);
                min=gap;
            }else if(gap==min){
                List<Integer>data = Arrays.asList(cur,next);
                result.add(data);
            }
        }
        return result;
    }
}