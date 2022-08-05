package com.another.leetcode.binaryTree;

public class addOneRow {
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
class Solution2222 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode x = new TreeNode(val);
            x.left=root;
            return x;
        }else{
            travel(root,val,1,depth);
            return root;
        }
    }
    public void travel(TreeNode root,int val,int current,int depth){
        if(root!=null){

            if(current+1==depth){
                if(root.left!=null){
                    TreeNode leftChild = new TreeNode(val);
                    leftChild.left=root.left;
                    root.left=leftChild;
                }else{
                    TreeNode leftChild = new TreeNode(val);
                    root.left=leftChild;
                }

                if(root.right!=null){

                    TreeNode rightChild = new TreeNode(val);
                    rightChild.right=root.right;
                    root.right=rightChild;
                }else{
                    TreeNode rightChild = new TreeNode(val);
                    root.right=rightChild;
                }

            }else{
                travel(root.left,val,current+1,depth);
                travel(root.right,val,current+1,depth);
            }
        }
    }
}