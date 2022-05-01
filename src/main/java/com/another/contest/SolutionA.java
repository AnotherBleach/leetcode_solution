package com.another.contest;

public class SolutionA {

    public int convertTime(String current, String correct) {
        String[] current_time = current.split(":");

        String[] correct_time = correct.split(":");

        int total_current_time = Integer.parseInt(current_time[0]) * 60 + Integer.parseInt(current_time[1]);
        int total_correct_time = Integer.parseInt(correct_time[0]) * 60 + Integer.parseInt(correct_time[1]);

        int delta = total_correct_time - total_current_time;

        int ans = 0;
        ans = ans + delta / 60;
        delta %= 60;

        ans = ans + delta / 15;
        delta %= 15;

        ans = ans + delta / 5;
        delta %= 5;

        ans = ans + delta;
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new SolutionA().convertTime("02:30","04:35"));
    }
}
