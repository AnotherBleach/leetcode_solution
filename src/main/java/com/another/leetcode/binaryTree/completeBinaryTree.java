package com.another.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class completeBinaryTree {
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
class CBTInserter {
    List<TreeNode> nodes= new ArrayList<>();
    public CBTInserter(TreeNode root) {
        nodes.add(new TreeNode());

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            TreeNode head = queue.pop();
            nodes.add(head);
            if(head.left!=null){
                queue.add(head.left);
            }

            if(head.right!=null){
                queue.add(head.right);
            }

        }

    }

    public int insert(int val) {
        TreeNode tmp = new TreeNode(val);
        nodes.add(tmp);
        int index=(nodes.size()-1)/2;
        TreeNode parent= nodes.get(index);
        if(nodes.size()%2==0){
            parent.right=tmp;
        }else{
            parent.left=tmp;
        }

        return parent.val;
    }

    public TreeNode get_root() {
        if(nodes.size()==1)return null;
        return nodes.get(1);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */