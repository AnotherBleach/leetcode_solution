package com.another.leetcode.dfs;

import com.another.leetcode.bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class print_binary_tree {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution2222222222 {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root)-1;
        int row=height+1;
        int col=(int)Math.pow(2,row)-1;

        int[][]tmp = new int[row][col];
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[i].length;j++){
                tmp[i][j]=-100;
            }
        }


        travel(root,tmp,0,col/2,height);
        List<List<String>>data = new ArrayList<>();

        for(int i=0;i<tmp.length;i++)
        {
            List<String>inner = new ArrayList<>();
            for(int j=0;j<tmp[i].length;j++){
                if(tmp[i][j]==-100){
                    inner.add("");
                }else{
                    inner.add(tmp[i][j]+"");
                }
            }
            data.add(inner);
        }
        return data;

    }
    public void travel(TreeNode root,int[][]tmp,int r,int c,int height){
        if(root!=null){

            tmp[r][c]=root.val;
            int cur = (int)Math.pow(2,height-r-1);
            travel(root.left,tmp,r+1,c-cur,height);
            travel(root.right,tmp,r+1,c+cur,height);
        }
    }
    public int getHeight(TreeNode root){
        if(root!=null){
            int left=getHeight(root.left);
            int right = getHeight(root.right);
            int max=Math.max(left,right);
            return 1+max;
        }
        return 0;
    }
}
