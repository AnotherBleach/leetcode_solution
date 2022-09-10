package com.another.leetcode.binaryTree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class maximumWith {

    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> dataQueue = new LinkedList<>();

        nodeQueue.add(new TreeNode(1));
        dataQueue.add(1);
        int maxVal = -1;
      
        while (!dataQueue.isEmpty() && !nodeQueue.isEmpty()) {
            int size = dataQueue.size();

            Integer min = null;
            Integer max = null;

            for (int i = 0; i < size; i++) {
                TreeNode head = nodeQueue.poll();
                Integer headVal = dataQueue.poll();

                if (head.left != null) {
                    nodeQueue.add(head.left);
                    dataQueue.add(headVal * 2);
                }

                if (head.right != null) {
                    nodeQueue.add(head.right);
                    dataQueue.add(headVal * 2 + 1);
                }

                if (i == 0) {

                    min = headVal;


                } if (i == size - 1) {
                    max = headVal;
                }
            }



            maxVal = Math.max(maxVal, max - min + 1);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
    }
}
