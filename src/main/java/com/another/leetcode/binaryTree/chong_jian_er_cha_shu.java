package com.another.leetcode.binaryTree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class chong_jian_er_cha_shu {
    //root left right
    //left root right
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder,int preorder_start,int preorder_stop,int[] inorder,int inorder_start,int inorder_stop){
        if(preorder_start>preorder_stop||inorder_start>inorder_stop){
            return null;
        }

        int rootVal = preorder[preorder_start];
        TreeNode root = new TreeNode(rootVal);



        for(int j=inorder_start;j<=inorder_stop;j++){
            if(rootVal==inorder[j]){
                root.left=this.buildTree(preorder,preorder_start+1,j-inorder_start+preorder_start,inorder,inorder_start,j-1);
                root.right=this.buildTree(preorder,j-inorder_start+preorder_start+1,preorder_stop,inorder,j+1,inorder_stop);
                break;
            }
        }
        return root;

    }
}
