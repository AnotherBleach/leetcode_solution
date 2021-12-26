package com.another.leetcode.priorityQueue;

import java.util.PriorityQueue;

public class maximum_numbers_of_eatting_apples {
    class apple {
        int beginDay;
        int expireDay;
        int count;
    }

    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<apple> queue = new PriorityQueue<>((apple a, apple b) -> {
            if (a.expireDay != b.expireDay) {
                return a.expireDay - b.expireDay;
            }
            return a.count - b.count;
        });
        int i;
        for (i = 0; i < apples.length; i++) {
            apple a = new apple();
            a.beginDay = i;
            a.count = apples[i];
            a.expireDay = i + days[i];

            queue.add(a);

            while (!queue.isEmpty()) {
                apple top = queue.peek();
                if (top.expireDay > i && top.count > 0) {
                    top.count--;
                    ans++;

                    break;
                } else {
                    queue.poll();
                }
            }

        }

        while (!queue.isEmpty()) {

            while (!queue.isEmpty()) {
                apple top = queue.peek();
                if (top.expireDay > i && top.count > 0) {
                    ans++;
                    top.count--;
                    break;
                } else {
                    queue.poll();
                }

            }
            i++;

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new maximum_numbers_of_eatting_apples().eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
    }
}
