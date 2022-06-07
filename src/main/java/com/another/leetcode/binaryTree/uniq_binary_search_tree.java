package com.another.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class uniq_binary_search_tree {

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return this.build(1, n);
    }

    public List<TreeNode> build(int start, int stop) {
        List<TreeNode> result = new ArrayList<>();


        if (start == stop) {
            TreeNode node = new TreeNode(start);
            result.add(node);
            return result;
        }

        for (int root = start; root <= stop; root++) {

            List<TreeNode> leftList = build(start, root - 1);
            List<TreeNode> rightList = build(root + 1, stop);

            if (leftList.size() == 0) {
                for (TreeNode rightNode : rightList) {

                    TreeNode head = new TreeNode(root);
                    head.left = null;
                    head.right = rightNode;
                    result.add(head);
                }
            } else if (rightList.size() == 0) {
                for (TreeNode leftNode : leftList) {

                    TreeNode head = new TreeNode(root);
                    head.left = leftNode;
                    head.right = null;
                    result.add(head);
                }
            } else {
                for (TreeNode leftNode : leftList) {
                    for (TreeNode rightNode : rightList) {

                        TreeNode head = new TreeNode(root);
                        head.left = leftNode;
                        head.right = rightNode;
                        result.add(head);
                    }
                }
            }

        }


        return result;
    }
}