package com.another.leetcode.bfs;

import java.util.*;
import java.util.function.ToIntFunction;

public class max_level_sum {



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
class Solution {
    public int maxLevelSum(TreeNode root) {
        int val=root.val,level=1;

        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        int size;
        int sum=0;
        int layer=1;
        while(queue.isEmpty()==false){
            sum=0;
            size=queue.size();
            while(size!=0){

                TreeNode tmp = queue.poll();
                sum+=tmp.val;
                if(tmp.left!=null)queue.add(tmp.left);
                if(tmp.right!=null)queue.add(tmp.right);
                size--;
            }
            if(sum>val){

                val=sum;
                level=layer;
            }

            layer++;


        }


        return level;

    }

    public static void main(String[] args) {
        String a = "123";
        String b="123";
        String c=new String("123");
        System.out.printf("%x %x %x",a.hashCode(),b.hashCode(),c.hashCode());
        List<Integer> data = new ArrayList<>();

    }

 
}
