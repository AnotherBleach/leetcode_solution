package com.another.leetcode.binarySearch;

public class valid_perfect_square {
    public boolean isPerfectSquare(int num) {

        int l = 1, r = num;
        while (l <= r) {
            long mid = l + (r - l) / 2;

            long tmp = mid * mid;
            if (tmp == num) {
                return true;
            } else if ( tmp > num) {
                r = (int) (mid - 1);
            } else {
                l = (int) (mid + 1);
            }
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(new valid_perfect_square().isPerfectSquare(2147395600));
    }
}
