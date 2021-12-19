package com.another.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class zero_one_matrix {

    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();

        int[][] data = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int newX, newY;

        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    int[] tmp = new int[]{i, j, 0};
                    visited[i][j] = true;
                    queue.add(tmp);
                }
            }


        while (!queue.isEmpty()) {

            int[] top = queue.poll();

            data[top[0]][top[1]] = top[2];
            for (int i = 0; i < move.length; i++) {

                newX = top[0] + move[i][0];
                newY = top[1] + move[i][1];
                if (newX < 0 || newX >= mat.length || newY < 0 || newY >= mat[0].length || visited[newX][newY])
                    continue;
                visited[newX][newY] = true;
                int[] tmp = new int[]{newX, newY, top[2] + 1};
                queue.add(tmp);

            }

        }

        return data;

    }
}
