package com.another.tools;

import java.util.HashMap;
import java.util.Map;

public class MyLinkedHashMap<K, V> extends HashMap<K, V> {
    private final boolean lru;
    Node head;
    Node tail;

    class Node {
        V v;
        K k;
        Node pre;
        Node next;

        Node() {

        }

        Node(K k, V v) {
            this.v = v;
            this.k = k;
        }
    }

    HashMap<K, Node> map;

    public MyLinkedHashMap(int initialSize) {
        this(initialSize, false);
    }

    public MyLinkedHashMap() {
        this(8);
    }

    public MyLinkedHashMap(boolean lru) {
        this(8, lru);
    }

    public MyLinkedHashMap(int initialSize, boolean lru) {
        map = new HashMap<>(initialSize);
        this.lru = lru;
    }

    public V get(Object k) {
        if (!map.containsKey(k)) {
            return null;
        }
        Node cur = map.get(k);
        if (lru) {
            // 如果只有一个节点 没必要维护

                unlink(cur);
                append(cur);

        }
        return cur.v;
    }

    public V put(K k, V v) {
        Node cur = new Node(k, v);
        putNode(cur);
        map.put(k, cur);
        return v;
    }

    private void putNode(Node cur) {
        if (head == null) {
            head = tail = cur;
        } else {
            Node old = head;
            head = cur;
            cur.next = old;
            old.pre = head;
            head.pre=null;
        }
    }

    private void append(Node cur) {
        putNode(cur);
    }

    private void unlink(Node cur) {
        if (cur == null) {
            return;
        }

        Node pre_node = cur.pre;
        Node next_node = cur.next;
        if (pre_node != null) pre_node.next = next_node;
        if (next_node != null) next_node.pre = pre_node;

        if (cur == head) {
            head = head.next;
            if (head == null) tail = head;
            else head.pre = null;
        } else if (cur == tail) {
            tail = tail.pre;
            tail.next = null;
        }
        cur.next=cur.pre=null;

    }

    public void printAllData() {
        while (head != null) {
            System.out.println(head.k + "->" + head.v);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedHashMap<String/*姓名*/, Integer/*年龄*/> data = new MyLinkedHashMap<>();
        data.put("James", 1);
        data.put("Kobe", 2);
        data.put("Lily", 3);
        data.put("Jack", 4);

        System.out.println(data.get("James"));
        System.out.println(data.get("Kobe"));
        data.printAllData();

        System.out.println("-----------------------");

        data = new MyLinkedHashMap<>(true);
        data.put("James", 1);
        data.put("Kobe", 2);
        data.put("Lily", 3);
        data.put("Jack", 4);

        System.out.println(data.get("James"));
        System.out.println(data.get("Kobe"));
        System.out.println(data.get("Kobe"));
        System.out.println(data.get("Kobe"));
        System.out.println(data.get("Kobe"));
        System.out.println(data.get("Kobe"));
        System.out.println(data.get("Kobe"));
        data.put("JJJJJ", 5);

        System.out.println(data.get("Jack"));
        System.out.println(data.get("Kobe"));

        data.printAllData();


    }

}
