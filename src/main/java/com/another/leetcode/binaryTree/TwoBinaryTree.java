package com.another.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class TwoBinaryTree {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> data1 = new ArrayList<>();
        inOrder(root1, data1);

        List<Integer> data2 = new ArrayList<>();
        inOrder(root2, data2);
        return merge(data1, data2);
    }

    private List<Integer> merge(List<Integer> data1, List<Integer> data2) {
        List<Integer> result = new ArrayList<>();
        int data1_size = data1.size(), data2_size = data2.size();
        int i = 0, j = 0;

        while (i < data1_size && j < data2_size) {

            if (data1.get(i) < data2.get(j)) {
                result.add(data1.get(i));
                i++;
            } else {
                result.add(data2.get(j));
                j++;
            }

        }

        while (i < data1_size) {
            result.add(data1.get(i));
            i++;
        }

        while (j < data2_size) {
            result.add(data2.get(j));
            j++;
        }

        return result;
    }

    private void inOrder(TreeNode root1, List<Integer> data) {
        if(root1==null){
            return;
        }
        inOrder(root1.left,data);
        data.add(root1.val);
        inOrder(root1.right,data);
    }
}
