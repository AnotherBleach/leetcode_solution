package com.another.leetcode.simulation;

public class find_missing_observations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ans = new int[n];
        int total = mean*(n+rolls.length);

        int totalM = 0;
        for(int i=0;i<rolls.length;i++){
            totalM+=rolls[i];
        }

        int left=total-totalM;
        int max=6*n;
        int min=1*n;
        if(left<min||left>max)return new int[0];
        int avg=left/n;
        for(int i=0;i<ans.length;i++)ans[i]=avg;

        left-=n*avg;
        int index=0;
        while(left!=0){
            if(ans[index]+left<=6){
                ans[index]+=left;
                left=0;
            }else{
                left=left-(6-ans[index]);
                ans[index]=6;
            }
            index++;
        }



        return ans;

    }

    public static void main(String[] args) {
        int[] data = new find_missing_observations().missingRolls(new int[]{4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5},4,40);
        System.out.println(data.length);
        for(int i=0;i<data.length;i++)
            System.out.print(data[i]+" ");
        System.out.println();
    }
}
