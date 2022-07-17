package com.another.leetcode.linkedList;

import java.util.HashSet;

public class MyLinkedList {

    Node dummyHead;
    Node tail;
    int len;

    public MyLinkedList() {
        dummyHead = new Node();
        tail =null;
        len = 0;
    }

    public int get(int index) {
        if (index >= len || index < 0) return -1;
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public void addAtHead(int val) {
        Node newHead = new Node();
        newHead.data = val;
        len++;

        if (dummyHead.next == null) {
            dummyHead.next = newHead;
            tail = newHead;
        } else {
            newHead.next = dummyHead.next;
            dummyHead.next = newHead;
        }
    }

    public void addAtTail(int val) {
        Node tmp = new Node();
        tmp.data = val;

        if (tail == null) {
            dummyHead.next = tmp;
            tail = tmp;
            len = 1;
        } else {
            len++;
            tail.next = tmp;
            tail = tmp;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > len) return;
        if (index < 0) {
            addAtHead(val);
            return;
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node tmp = new Node();
        tmp.data = val;
        tmp.next = cur.next;
        cur.next = tmp;
        if(cur==tail){
            tail=cur.next;
        }
        len++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) return;
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if (cur.next.next == null) {
            tail = cur;
            cur.next = null;
        } else {
            cur.next = cur.next.next;
        }
        len--;

    }

    class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.get(0);
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);

        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(6);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
