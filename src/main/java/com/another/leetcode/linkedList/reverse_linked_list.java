package com.another.leetcode.linkedList;

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

public class reverse_linked_list {
    /**
     * 递归版本
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tempHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tempHead;
    }

    /**
     * 迭代版本
     *
     * @param head
     * @return
     */
    public ListNode reverseListV2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head.next != null) {
            ListNode next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        head.next=pre;
        return head;
    }

}
