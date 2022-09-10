package com.another.leetcode.bfs;

import java.util.*;

public class transform_to_cheseboard {
    class Node {
        int x;
        int y;
        int path;
        int[][] currentArray;
        int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        Node() {

        }

        Node(int x, int y, int path, int[][] currentArray) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.currentArray = currentArray;
        }

        private boolean isFuckingOk() {
            for (int i = 0; i < currentArray.length; i++) {
                for (int j = 0; j < currentArray[i].length; j++) {
                    if (isNotOk(i, j, currentArray)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isNotOk(int i, int j, int[][] currentArray) {
            for (int p = 0; p < move.length; p++) {
                int x = p + move[0][0];
                int y = p + move[0][1];
                if (x >= 0 && y >= 0 && x < currentArray.length && y < currentArray[0].length) {
                    if (currentArray[x][y] == currentArray[i][j]) return false;
                }
            }
            return true;
        }

        public List<Node> findNext() {
            List<Node> result = new ArrayList<>();

            return result;
        }
    }

    public int movesToChessboard(int[][] board) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, board));


        while (!queue.isEmpty()) {

            Node head = queue.poll();
            if (head.isFuckingOk()) {
                return head.path;
            }

            List<Node> nodeList = head.findNext();
            for (Node node : nodeList) {
                int x = convert(node.currentArray);
                if (!visited.contains(x)) {
                    visited.add(x);
                    queue.add(node);
                }
            }

        }
        return -1;
    }

    public int convert(int[][] input) {
        return 1;
    }
}
