package com.another.leetcode.simulation;

import java.util.HashMap;
import java.util.Map;

public class Day_Of_The_Week {
    Map<Integer, String> nameMap = new HashMap<>();

    {
        nameMap.put(1, "Friday");
        nameMap.put(2, "Saturday");
        nameMap.put(3, "Sunday");
        nameMap.put(4, "Monday");
        nameMap.put(5, "Tuesday");
        nameMap.put(6, "Wednesday");
        nameMap.put(0, "Thursday");
    }

    Map<Integer, Integer> yearMap = new HashMap<>();

    {

        for (int i = 1971; i <= 2100; i++) {
            if (isRun(i)) {
                yearMap.put(i, yearMap.getOrDefault(i - 1, 0) + 366);
            } else {
                yearMap.put(i, yearMap.getOrDefault(i - 1, 0) + 365);
            }
        }

    }

    Map<Integer, Integer> monthMap = new HashMap<>();

    {
        int[] data = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i <= 12; i++) {
            monthMap.put(i, monthMap.getOrDefault(i - 1, 0) + data[i]);
        }

    }

    private boolean isRun(int year) {

        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public String dayOfTheWeek(int day, int month, int year) {
        int total = yearMap.getOrDefault(year - 1, 0);
        total += monthMap.getOrDefault(month - 1, 0);
        total += day;
        if (month > 2 && isRun(year)) total++;
        total %= 7;
        return nameMap.get(total);
    }
}
