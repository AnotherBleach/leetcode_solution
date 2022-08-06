package com.another.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class robot {

}

class Solution3333333 {
    int[][]move = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    //dfs
    public int movingCount2(int m,int n,int k){
        if(k==0)return 1;
        return travel(0,0,m,n,k,new boolean[m][n]);
    }

    private int travel(int currentX, int currentY, int m, int n, int k, boolean[][] visited) {
        if(visited[currentX][currentY])return 0;
        int ans=1;
        visited[currentX][currentY]=true;
        for(int i=0;i<move.length;i++){
            int x=currentX+move[i][0];
            int y=currentY+move[i][1];
            if(x<0||y<0||x>=m||y>=n||visited[x][y])continue;

            if(isOk(x,y,k)){

                ans+=travel(x,y,m,n,k,visited);

            }

        }
        return ans;
    }


    //bfs
    public int movingCount(int m, int n, int k) {
        if(k==0)return 1;
        boolean[][]visited = new boolean[m][n];
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int ans=0;
        int[][]move = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        while(queue.isEmpty()==false){
            int size=queue.size();
            ans+=size;

            while(size--!=0){
                int[]pos=queue.poll();

                visited[pos[0]][pos[1]]=true;
                for(int i=0;i<move.length;i++){
                    int x=pos[0]+move[i][0];
                    int y=pos[1]+move[i][1];
                    if(x<0||y<0||x>=m||y>=n||visited[x][y])continue;

                    if(isOk(x,y,k)){
                        visited[x][y]=true;
                        queue.add(new int[]{x,y});

                    }

                }
            }
        }
        return ans;

    }

    boolean isOk(int x,int y,int k){

        int total=0;
        int tmp=0;
        while(x!=0){
            tmp=x%10;
            x/=10;
            total+=tmp;
        }


        while(y!=0){
            tmp=y%10;
            y/=10;
            total+=tmp;
        }

        return total<=k;
    }
}
