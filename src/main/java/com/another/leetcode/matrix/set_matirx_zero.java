package com.another.leetcode.matrix;

public class set_matirx_zero {
    // 原地置换，o（1）空间
    public void setZeroes(int[][] matrix) {

        // 先记录一下第一行、第一列有没有必要清0，很重要，因为后面把第一行第一列拿来做状态缓存，容易破坏掉之前的信息，所以先记录下来
        boolean row = false;
        boolean col = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                row = true;
                break;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                col = true;
                break;
            }
        }

        // 从1，1开始遍历，假设这个值为0，说明这一行这一列都要清0
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++) {

                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }


        // 按照第一行第一列记录的信息开始清空数据
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++) {

                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }

        //最后单独处理第一行和第一列的数据
        if (row) {
            for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
        }
        if (col) {
            for (int j = 0; j < matrix.length; j++) matrix[j][0] = 0;
        }


    }

}
