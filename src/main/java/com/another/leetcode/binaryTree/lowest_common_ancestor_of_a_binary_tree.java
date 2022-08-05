package com.another.leetcode.binaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode() {

    }
}

public class lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q)return root;
        if((root.left==p&&root.right==q) ||(root.left==q&&root.right==p))return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right= lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null)return root;
        return left==null? right : left;


    }
}
