package com.another.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {
    }

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class even_odd_tree {
    public boolean isEvenOddTree(TreeNode2 root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        //涉及到一个点，层次遍历时，怎么区分同一层节点，可以用一个变量size来记录
        while (!queue.isEmpty()) {

            int prev = 0;
            int size = queue.size();
            while (size-- != 0) {
                TreeNode2 cur = queue.poll();

                if (level % 2 == 0) {
                    if (cur.val % 2 == 0) return false;
                    if (prev == 0) prev = cur.val;
                    else {
                        if (cur.val <= prev) return false;
                    }
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                    prev = cur.val;

                } else {

                    if (cur.val % 2 == 1) return false;
                    if (prev == 0) prev = cur.val;
                    else {
                        if (cur.val >= prev) return false;
                    }
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                    prev = cur.val;
                }


            }
            level++;

        }
        return true;
    }
}
