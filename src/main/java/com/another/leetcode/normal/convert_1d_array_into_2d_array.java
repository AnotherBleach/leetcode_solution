package com.another.leetcode.normal;

/**
 * url: https://leetcode-cn.com/problems/convert-1d-array-into-2d-array/submissions/
 */
public class convert_1d_array_into_2d_array {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n!=original.length)return new int[0][0];
        int[][]data = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                data[i][j] = original[i*n+j];
            }
        return data;
    }
}
