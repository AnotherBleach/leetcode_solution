package com.another.leetcode.doublepointer;

public class merge_sorted_array {
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=n-1;
        int j=m-1;
        int pos=nums1.length-1;
        while(i>=0 && j>=0){
            if(nums1[j]>nums2[i]){
                nums1[pos]=nums1[j];
                j--;
                pos--;
            }else{
                nums1[pos]=nums2[i];
                i--;
                pos--;
            }

        }

        while(i>=0){
            nums1[pos]=nums2[i];
            pos--;
            i--;
        }

        while(j>=0){
            nums1[pos]=nums1[j];
            pos--;
            j--;
        }

    }
}