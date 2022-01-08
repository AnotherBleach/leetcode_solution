package com.another.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class gray_code {
    public List<Integer> grayCode(int n) {
        int x = 0;
        boolean last = true;
        List<Integer> data = new ArrayList<>();
        int maxSize = (int) Math.pow(2, n);
        data.add(0);
        while (data.size() < maxSize) {

            if (last) {
                if ((x & 1) == 1) {
                    x &= (~1);
                } else {
                    x |= 1;
                }
                data.add(x);

            } else {
                for (int i = 0; i < 32; i++) {
                    if (isOne(x, i)) {

                        if (isOne(x, i + 1)) {
                            int t = (1 << (i+1));
                            x &= (~t);
                        } else {
                            int t = (1 << (i+1));
                            x |= t;

                        }

                        data.add(x);
                        break;
                    }
                }
            }
            last = !last;

        }
        return data;
    }

    boolean isOne(int n, int i) {
        return (((n >> i)) & 1) == 1;
    }

    public static void main(String[] args) {
        System.out.println(new gray_code().grayCode(1));
    }
}
