package com.another.leetcode.simulation;

public class YueSheFu {
    int pos = 0;

    public int findTheWinner(int n, int k) {
        pos = 0;
        int[] person = new int[n];
        int kill = 0;
        if(n==1)return 1;

        do {
            runGame(k, person);
            kill++;
        } while (kill != n - 1);

        for (int i = 0; i < person.length; i++) {
            if (person[i] == 0) return i + 1;
        }
        return -1;
    }

    private void runGame(int k, int[] person) {
        while (person[pos] != 0) {
            pos = (pos + 1) % person.length;
        }
        int effect = 0;

        while (effect < k) {
            if (person[pos] == 0) {
                effect++;

                if(effect==k){
                    person[pos] = 1;
                }
            }
            pos = (pos + 1) % person.length;
        }


    }

    public static void main(String[] args) {
        System.out.println(new YueSheFu().findTheWinner(500, 137));
    }
}
