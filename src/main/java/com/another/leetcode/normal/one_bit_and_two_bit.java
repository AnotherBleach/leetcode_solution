package com.another.leetcode.normal;

public class one_bit_and_two_bit {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }

        if (bits.length == 2) {
            return bits[0] == 0;
        }

        for (int i = 0; i < bits.length; ) {

            if (bits[i] == 0) {
                i++;

            } else {
                i += 2;
            }

            if (i == bits.length - 1) {
                return true;
            }
        }
        return false;


    }

    public static void main(String[] args) {
        System.out.println(new one_bit_and_two_bit().isOneBitCharacter(new int[]{
                1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0
        }));
    }
}
