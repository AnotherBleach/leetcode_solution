package com.another.leetcode.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainVirus {
    int usedWall = 0;

    public int containVirus(int[][] isInfected) {
        Map<Integer, area> totalAreas = this.buildAreas(isInfected);

        while (totalAreas.size() > 0) {
            area tmp = this.findMostDangerousArea(totalAreas, isInfected);
            if (tmp == null) {
                return usedWall;
            }
            this.kill(tmp, isInfected);
            totalAreas.remove(tmp.val);
            for (area t : totalAreas.values()) {
                t.growUp(isInfected);
            }

            totalAreas = this.buildAreas(isInfected);
        }

        return usedWall;
    }

    private void kill(area tmp, int[][] isInfected) {
        int[][] move = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] t : tmp.pos) {

            isInfected[t[0]][t[1]] = -1;
            int cur_x, cur_y;
            for (int[] action : move) {
                cur_x = t[0] + action[0];
                cur_y = t[1] + action[1];
                if (cur_x < 0 || cur_x >= isInfected.length || cur_y < 0 || cur_y >= isInfected[0].length) continue;

                if (isInfected[cur_x][cur_y] == 0) {
                    usedWall++;
                }

            }

        }
    }

    private area findMostDangerousArea(Map<Integer, area> totalAreas, int[][] isInfected) {
        area result = null;
        int max = 0;

        List<int[]> modify = new ArrayList<>();
        int[][] move = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (Map.Entry<Integer, area> entry : totalAreas.entrySet()) {
            modify.clear();
            area value = entry.getValue();


            for (int[] t : value.pos) {


                int cur_x, cur_y;

                //look up
                //look left
                //look down
                //look right
                for (int[] action : move) {
                    cur_x = t[0] + action[0];
                    cur_y = t[1] + action[1];
                    if (cur_x < 0 || cur_x >= isInfected.length || cur_y < 0 || cur_y >= isInfected[0].length) continue;

                    if (isInfected[cur_x][cur_y] == 0) {
                        isInfected[cur_x][cur_y] = -2;
                        modify.add(new int[]{cur_x, cur_y});
                    }

                }


            }

            for (int[] tmp : modify) {
                isInfected[tmp[0]][tmp[1]] = 0;
            }
            if (max < modify.size()) {
                result = value;
                max = modify.size();
            }

        }

        return result;

    }

    private Map<Integer, area> buildAreas(int[][] isInfected) {
        Map<Integer, area> data = new HashMap<>();
        int cur = 2;
        for (int i = 0; i < isInfected.length; i++)
            for (int j = 0; j < isInfected[i].length; j++) {
                if (isInfected[i][j] == 1) {
                    boolean[][] visited = new boolean[isInfected.length][isInfected[0].length];
                    this.trvavel(isInfected, i, j, data, cur, visited);
                    cur++;
                }
            }

        return data;
    }

    private void trvavel(int[][] isInfected, int i, int j, Map<Integer, area> data, int cur, boolean[][] visited) {
        if (i < 0 || i >= isInfected.length || j < 0 || j >= isInfected[i].length) return;
        if (visited[i][j]) return;

        if (isInfected[i][j] == 1) {

            isInfected[i][j] = cur;
            visited[i][j] = true;

            area orDefault = data.getOrDefault(cur, new area());
            orDefault.val = cur;
            orDefault.pos.add(new int[]{i, j});
            data.put(cur, orDefault);

            //look up
            trvavel(isInfected, i - 1, j, data, cur, visited);


            //look left
            trvavel(isInfected, i, j - 1, data, cur, visited);

            //look down
            trvavel(isInfected, i + 1, j, data, cur, visited);

            //look right
            trvavel(isInfected, i, j + 1, data, cur, visited);

        }
    }

    class area {
        List<int[]> pos = new ArrayList<>();
        int val;
        boolean dead = false;
        int[][] move = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};


        public void growUp(int[][] isInfected) {
            this.val=1;
            List<int[]> toBeAdded = new ArrayList<>();
            for (int[] t : pos) {
                isInfected[t[0]][t[1]]=this.val;

                for (int[] action : move) {
                    int cur_x = t[0] + action[0];
                    int cur_y = t[1] + action[1];
                    if (cur_x < 0 || cur_x >= isInfected.length || cur_y < 0 || cur_y >= isInfected[0].length) continue;

                    if (isInfected[cur_x][cur_y] == 0) {
                        isInfected[cur_x][cur_y] = this.val;
                        toBeAdded.add(new int[]{cur_x, cur_y});
                    }


                }

            }
            this.pos.addAll(toBeAdded);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new ContainVirus().containVirus(new int[][]{
//                {0, 1, 0, 0, 0, 0, 0, 1},
//                {0, 1, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 0, 0, 0}
//        }));
//
//
//        System.out.println(new ContainVirus().containVirus(new int[][]{
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        }));
//
//
//
//        System.out.println(new ContainVirus().containVirus(new int[][]{
//                {1,1,1,0,0,0,0,0,0},
//                {1,0,1,0,1,1,1,1,1},
//                {1,1,1,0,0,0,0,0,0}
//        }));

        System.out.println(new ContainVirus().containVirus(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }));

    }
}
