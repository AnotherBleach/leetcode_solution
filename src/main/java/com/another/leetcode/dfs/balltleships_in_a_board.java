package com.another.leetcode.dfs;

public class balltleships_in_a_board {
    int[][] move = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};


    public int countBattleships(char[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                // 左边和上面都是空的
                if (board[i][j] == 'X' && (i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) cnt++;

            }
        return cnt;
    }

    public int countBattleships_DFS(char[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                dfs(i, j, board);
                cnt++;
            }
        return cnt;
    }

    public void dfs(int i, int j, char[][] board) {
        board[i][j] = '.';
        for (int p = 0; p < move.length; p++) {
            int x = i + move[p][0];
            int y = j + move[p][1];
            if (isValid(x, y, board.length, board[i].length)) {
                if (board[x][y] == 'X') dfs(x, y, board);
            }
        }
        return;
    }

    public boolean isValid(int x, int y, int xlen, int ylen) {
        if (x < 0 || x >= xlen) return false;
        if (y < 0 || y >= ylen) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new balltleships_in_a_board().countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}}));
    }
}
