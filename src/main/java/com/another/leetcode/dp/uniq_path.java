package com.another.leetcode.dp;

public class uniq_path {
    public int uniquePaths(int m, int n) {
        int[][]f=new int[m][n];

        for(int i=m-1;i>=0;i--){
            f[i][n-1]=1;
        }

        for(int j=n-1;j>=0;j--){
            f[m-1][j]=1;
        }

        for(int i=m-2;i>=0;i--)
            for(int j=n-2;j>=0;j--){
                f[i][j]=f[i][j+1]+f[i+1][j];
            }
        return f[0][0];
    }
}
