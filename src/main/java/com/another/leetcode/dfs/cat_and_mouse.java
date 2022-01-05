package com.another.leetcode.dfs;

import java.util.Arrays;

public class cat_and_mouse {
    public int catMouseGame(int[][] graph) {
        int[][][] visited = new int[graph.length][graph.length][3 * graph.length];

        for (int[][] ints : visited) {
            for (int[] d : ints)
                Arrays.fill(d, -1);
        }
        return calc(1, 2, graph, visited, 0);

    }

    public int calc(int mouse, int cat, int[][] graph, int[][][] visited, int step) {

        if (step > 2 * graph.length) {
            visited[mouse][cat][step] = 0;
            return 0;
        }


        if (mouse == cat) {
            visited[mouse][cat][step] = 2;
            return 2;
        }

        if (mouse == 0) {
            visited[mouse][cat][step] = 1;
            return 1;
        }


        if (visited[mouse][cat][step] != -1) {
            return visited[mouse][cat][step];
        }


        if (step % 2 == 0) {
            boolean canZero = false;
            for (int i : graph[mouse]) {
                int res = calc(i, cat, graph, visited, step + 1);
                if (res == 1) {
                    visited[mouse][cat][step] = 1;
                    return 1;
                }
                if (res == 0) canZero = true;
            }

            if (canZero) {
                visited[mouse][cat][step] = 0;
                return 0;
            }
            visited[mouse][cat][step] = 2;
            return 2;
        } else {
            boolean canZero = false;
            for (int i : graph[cat]) {
                if (i == 0) continue;
                int res = calc(mouse, i, graph, visited, step + 1);
                if (res == 2) {
                    visited[mouse][cat][step] = 2;
                    return 2;
                }
                if (res == 0) canZero = true;
            }

            if (canZero) {
                visited[mouse][cat][step] = 0;
                return 0;
            }
            visited[mouse][cat][step] = 1;
            return 1;
        }

    }
}