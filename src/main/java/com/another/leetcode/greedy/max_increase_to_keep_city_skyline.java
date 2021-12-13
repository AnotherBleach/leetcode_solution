package com.another.leetcode.greedy;

public class max_increase_to_keep_city_skyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum=0;
        int[] row = new int[grid.length];
        int[] col = new int[grid.length];
        for(int i=0;i<grid.length;i++)
        {
            int maxRow=-1;
            int maxCol=-1;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>maxRow)maxRow=grid[i][j];
                if(grid[j][i]>maxCol)maxCol=grid[j][i];
            }
            row[i]=maxRow;
            col[i]=maxCol;
        }

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++){

                sum+=Math.min(row[i],col[j])-grid[i][j];
            }

        }
        return sum;
    }
}
