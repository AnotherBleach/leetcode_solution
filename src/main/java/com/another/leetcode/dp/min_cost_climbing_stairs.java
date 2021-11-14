package com.another.leetcode.dp;

public class min_cost_climbing_stairs {
    public int minCostClimbingStairs(int[] cost) {
        int[]s= new int[cost.length];

        if(cost.length<=2){
            if(cost.length==1)return cost[0];
            return Math.min(cost[0],cost[1]);
        }


        s[s.length-1]=0;
        s[s.length-2]=Math.min(cost[cost.length-1],cost[cost.length-2]);

        for(int j=s.length-3;j>=0;j--)
        {

            s[j]=Math.min(cost[j]+s[j+1],cost[j+1]+s[j+2]);
        }
        return s[0];


    }
}
