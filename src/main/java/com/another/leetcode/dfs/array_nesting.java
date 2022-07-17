package com.another.leetcode.dfs;

public class array_nesting {
}
class Solution {
    int max=-1;
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            travel(nums,visited,0,i);
        }
        return max;
    }
    public void travel(int[] nums,boolean[]visited,int cost,int startPos){
        if(visited[startPos]){

            max=Math.max(cost,max);
            return;
        }
        visited[startPos]=true;
        int nextPos = nums[startPos];
        travel(nums,visited,cost+1,nextPos);

    }
}
