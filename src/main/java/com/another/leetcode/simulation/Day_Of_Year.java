package com.another.leetcode.simulation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Day_Of_Year {
    final int[] ans = new int[]{0, 31, 59, 90/*+31*/, 120/*+30*/, 151/*+31*/, 181/*30*/, 212/*31*/, 243/*31*/,
            273/*30*/, 304/*31*/, 334, 365};

    public boolean isRunYear(int x) {
        return (x % 4 == 0 && x % 100 != 0) || x % 400 == 0;
    }

    public int dayOfYear(String date) {
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate now = LocalDate.parse(date, fmt);
//        return now.getDayOfYear();
        int[] tmp = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
        return ans[tmp[1] - 1] + tmp[2] + (tmp[1] > 2 && isRunYear(tmp[0]) ? 1 : 0);

    }

}
