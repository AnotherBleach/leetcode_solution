package com.another.leetcode.matrix;

public class rotate_image {

    public void rotate(int[][] matrix) {
        transfer(matrix);
        revert(matrix);
    }

    public void transfer(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }

    public void revert(int[][] matrix) {
        int len = matrix.length / 2;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < len; j++) {

                int temp = matrix[i][j];
                //0 1 2 3
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
    }

}
