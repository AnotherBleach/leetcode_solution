package com.another.leetcode.simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class maximum_equal_frequency {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = data.getOrDefault(nums[i], 0);
            data.put(nums[i], x + 1);
        }


        for (int j = nums.length - 1; j >= 0; j--) {
            if (ok(data)) {
                return j+1;
            }

            int current = data.get(nums[j]);
            if (current == 1) data.remove(nums[j]);
            else data.put(nums[j], current - 1);


        }
        return 0;
    }


    public boolean ok(Map<Integer, Integer> data) {
        Map<Integer, Integer> tmp = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            int current = tmp.getOrDefault(entry.getValue(),0);
            tmp.put(entry.getValue(),current+1);
            if(tmp.size()>2)return false;
        }

        if(tmp.size()==1){
            for(Map.Entry<Integer,Integer>entry:tmp.entrySet()){
                return entry.getKey()==1||entry.getValue()==1;

            }
        }
        int preKey=-1,preVal=-1;
        for(Map.Entry<Integer,Integer>entry: tmp.entrySet()){
            if(entry.getKey()==1 && entry.getValue()==1)return true;
            if(preKey==-1){
                preKey=entry.getKey();
                preVal=entry.getValue();
            }else{
                int delta = preKey-entry.getKey();
                if(delta==-1){
                    return entry.getValue()==1;
                }
                if(delta==1){
                    return preVal==1;
                }
            }
        }
        return false;

    }
    public static void main(String[] args) {
        System.out.println(new maximum_equal_frequency().maxEqualFreq(new int[]{1,1}));
    }
}