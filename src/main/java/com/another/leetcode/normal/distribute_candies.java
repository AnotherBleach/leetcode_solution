package com.another.leetcode.normal;

import java.util.HashSet;
import java.util.Set;

public class distribute_candies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> sets = new HashSet<>();

        for(int i:candyType){
            sets.add(i);
        }
        int half = candyType.length/2;

        return Math.min(sets.size(), half);
    }
}
