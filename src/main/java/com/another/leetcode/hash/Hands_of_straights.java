package com.another.leetcode.hash;

import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Hands_of_straights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < hand.length; i++) {
            Integer tmp = treeMap.getOrDefault(hand[i], 0);
            treeMap.put(hand[i], tmp + 1);
        }

        ArrayList<Integer> keys = new ArrayList<>(treeMap.navigableKeySet());
        for (int i = 0; i < keys.size() - 1; i++) {

            if(keys.get(i)+1!=keys.get(i+1))return false;
        }
        int startIndex = 0;
        int len = keys.size();

        while (true) {

            if (startIndex + groupSize - 1 >= len) {

                for (int i = startIndex; i < len; i++) {
                    if (treeMap.get(keys.get(i)) != 0) return false;
                }
                return true;
            }
            int data = treeMap.get(keys.get(startIndex));

            if (data == 0) startIndex++;
            else if (data < 0) return false;
            else {

                for (int j = startIndex; j < startIndex + groupSize; j++) {
                    Integer x = treeMap.get(keys.get(j));
                    treeMap.put(keys.get(j), x - data);
                }
            }

        }


    }

    public static void main(String[] args) {
        System.out.println(new Hands_of_straights().isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8, 9, 4, 5, 10, 33, 66, 0, 11, 23}, 3));
    }
}
