package com.another.leetcode.priorityQueue;

import java.util.PriorityQueue;

public class longest_happy_string {

    public static void main(String[] args) {
        System.out.println(new longest_happy_string().longestDiverseString(1,1,7));
    }
    public String longestDiverseString(int a, int b, int c) {
        node aa = new node(a, 'a');
        node bb = new node(b, 'b');
        node cc = new node(c, 'c');
        PriorityQueue<node> data = new PriorityQueue<>((x1, x2) -> {
            return x2.id - x1.id;
        });
        data.add(aa);
        data.add(bb);
        data.add(cc);

        StringBuilder sb = new StringBuilder();
        char pre = '#';
        int count = 0;

        while (data.isEmpty() == false) {

            node tmp = data.poll();

            if (tmp.id == 0) continue;

            if (pre == tmp.chr) {

                if (count == 1) {
                    count++;
                    tmp.id--;
                    data.add(tmp);
                    sb.append(tmp.chr);
                } else {

                    node tmp2 = data.poll();
                    if (tmp2 == null || tmp2.id == 0)
                        break;

                    pre = tmp2.chr;
                    count = 1;
                    tmp2.id--;

                    sb.append(pre);
                    data.add(tmp);
                    data.add(tmp2);
                }
            } else {

                sb.append(tmp.chr);
                tmp.id--;
                data.add(tmp);
                count=1;
                pre = tmp.chr;
            }


        }

        return sb.toString();

    }

    class node {
        int id;
        char chr;

        node(int id, char chr) {
            this.id = id;
            this.chr = chr;
        }
    }

}

