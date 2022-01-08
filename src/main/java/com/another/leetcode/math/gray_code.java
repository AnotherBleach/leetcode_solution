package com.another.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class gray_code {
    // 方法一： 通过直接排列得到
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
                            int t = (1 << (i + 1));
                            x &= (~t);
                        } else {
                            int t = (1 << (i + 1));
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


    // 方法二： 通过镜像得到
    public List<Integer> grayCodeV2(int n) {
        List<Integer> data = new ArrayList<>();
        data.add(0);
        data.add(1);
        for (int i = 2; i <= n; i++) {
            int size = data.size();
            for (int j = size-1; j >= 0; j--) {
                data.set(j,data.get(j)<<1);
                data.add(data.get(j)+1);
            }
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println(new gray_code().grayCodeV2(2));
    }
}
