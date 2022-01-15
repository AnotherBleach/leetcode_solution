package com.another.leetcode.matrix;

public class SearchInSortedMatrix {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if(matrix.length==0)return false;
            return search(matrix,0,matrix[0].length-1,target);
        }
        public boolean search(int[][] matrix,int rowStart,int colEnd,int target){
            if(rowStart>=matrix.length||colEnd<0)return false;
            if(matrix[rowStart][colEnd]==target)return true;
            if(matrix[rowStart][colEnd]>target)return search(matrix,rowStart,colEnd-1,target);
            return search(matrix,rowStart+1,colEnd,target);

        }
    }
}
