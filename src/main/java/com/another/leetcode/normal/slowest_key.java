package com.another.leetcode.normal;

import java.util.Stack;

public class slowest_key {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Stack<Integer> data;
        int max = releaseTimes[0];
        char c = keysPressed.charAt(0);
        int temp;
        for (int j = 1; j < releaseTimes.length; j++) {
            temp = releaseTimes[j] - releaseTimes[j - 1];
            if(temp>max){
                max=temp;
                c=keysPressed.charAt(j);
            }else if(temp==max){
                if(keysPressed.charAt(j)>c){
                    c=keysPressed.charAt(j);
                }
            }
        }
        return c;
    }
}
