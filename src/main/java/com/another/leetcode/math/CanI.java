package com.another.leetcode.math;

import java.util.HashMap;

public class CanI {

    // 0--me
    // 1--you
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;


        return dfs(maxChoosableInteger, 0, desiredTotal, 0, new HashMap<Integer, Boolean>());

    }

    public boolean dfs(int max, int visited, int desiredTotal, int current, HashMap<Integer, Boolean> memory) {

        if (current >= desiredTotal) {
            memory.put(visited,false);
            return false;
        }
        if (memory.get(visited) != null) {
            return memory.get(visited);
        }

        for (int i = 0; i < max; i++) {

            if(((visited>>i)&1)==1){
                continue;
            }
            int curPos = 1 << i;



            boolean canWin =dfs(max,visited|curPos,desiredTotal,current+i+1,memory);
            if(canWin){
                memory.put(visited|curPos,false);
            }else{
                memory.put(visited|curPos,true);
            }

        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(new CanI().canIWin(10, 11));
    }
}
