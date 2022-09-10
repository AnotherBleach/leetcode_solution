package com.another.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

public class quick {


    public void quickSort(int[] arr, int i, int j,int k) {


        if (i >j) {

            return;}

        int pos = split(arr, i, j);


        if (pos == i) {
            quickSort(arr, i + 1, j,k);
            return;
        }

        if (pos == j) {
            quickSort(arr, i, j - 1,k);
        }

        quickSort(arr, i, pos - 1,k);
        quickSort(arr, pos + 1, j,k);


    }

    private int split(int[] arr, int i, int j) {
        if (i == j) return i;

        int q = i + 1, p = j;
        while (q <= p) {
            while (q <= p && arr[q] <= arr[i]) q++;
            while (q <= p && arr[p] >= arr[i]) p--;
            if (q <= p) {
                int tmp = arr[q];
                arr[q] = arr[p];
                arr[p] = tmp;
            }
        }

        int tmp = arr[i];
        arr[i] = arr[p];
        arr[p] = tmp;

        return p;

    }

    public int[] genData(int n) {
        int[] data = new int[n];
        Random rd = new Random();
        for (int i = 0; i < data.length; i++)
            data[i] = rd.nextInt(100);
        return data;
    }

    public boolean verify(int[] src, int[] des) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] != des[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        quick d = new quick();

        int[] ints = d.genData(100);

        int[] ints_copy = new int[100];
        System.arraycopy(ints, 0, ints_copy, 0, ints.length);


        Arrays.sort(ints);
        d.quickSort(ints_copy, 0, ints_copy.length - 1,3);

        if (d.verify(ints, ints_copy)) {
            System.out.println("相等");
            System.out.println(Arrays.deepToString(new int[][]{ints}));
            System.out.println(Arrays.deepToString(new int[][]{ints_copy}));
        }else{
            System.out.println("shit");
            System.out.println(Arrays.deepToString(new int[][]{ints}));
            System.out.println(Arrays.deepToString(new int[][]{ints_copy}));
        }


    }
}
