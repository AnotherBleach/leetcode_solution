package com.another.leetcode.simulation;



class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] My_Master = new int[n+1];
        int[] My_Follower = new int[n+1];
        for(int i=0;i<trust.length;i++)
        {
            My_Master[trust[i][0]]++;
            My_Follower[trust[i][1]]++;
        }
        for(int i=1;i<=n;i++){
            if(My_Master[i]==0 && My_Follower[i]==n-1)return i;
        }
        return -1;

    }
}
public class find_the_town_judge {

}
