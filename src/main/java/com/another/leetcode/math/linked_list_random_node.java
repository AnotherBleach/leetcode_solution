package com.another.leetcode.math;

import java.util.Random;

public class linked_list_random_node {
    public static void main(String[] args) {

    }
}

/**
 * 链表中随机选择一个结点
 * <p>
 * 1、如果链表长度有限： 算出总长度然后random
 * 2、假设链表无限长： 蓄水池采样算法
 *
 * 从N个数选k个
 *
 * 前个k直接放进去，后面的第j个，以k/j的概率替换
 *
 * 证明：每个元素留下的概率=被选中*不被替换
 * 前k个
 *
 * 选择概率1
 * 不被第k+1替换： k/(k+1)
 * 不被第k+2替换： (k+1)/(k+2)
 *
 * = 1* (k/k+1) * (k+1)/(k+2)*...*(n-1)/(n)=k/n
 *
 * 后面
 * 选中概率： k/j
 *
 * 不被第j+1替换： j/(j+1)
 * 不被第j+2替换： (j+1)/(j+2)
 * =k/j *(j/j+1)*(j+1)/(j+2)*...*(n-1/n)=k/n
 */
class Solution {


    ListNode head;
    public Solution(ListNode head) {
        this.head=head;
    }

    public int getRandom() {

        if(head.next==null)return head.val;
        Random rd = new Random();
        int result=head.val;
        ListNode cur=head;
        int totalNumber=1;
        while(cur!=null){

            int temp=rd.nextInt(totalNumber);
            if(temp==0)result=cur.val;
            cur=cur.next;
            totalNumber++;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}