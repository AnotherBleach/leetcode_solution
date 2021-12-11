package com.another.leetcode.math;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * 这个版本要简洁一点
 */
class TopVotedCandidate {

    TreeMap<Integer/*用户投票的时间点*/, Integer/*序号*/> map = new TreeMap<>();


    public TopVotedCandidate(int[] persons, int[] times) {


        int[] current = new int[persons.length];

        int maxScore=-1;
        int id=-1;
        for (int i = 0; i < times.length; i++) {
            current[persons[i]]++;
            if(current[persons[i]]>=maxScore){
                maxScore=current[persons[i]];
                id=persons[i];
            }
            map.put(times[i], id);

        }


    }


    public int q(int t) {
        Integer i = map.floorKey(t);
        if (i == null) {
            return map.firstEntry().getValue();
        }
        return map.get(i);
    }
}

/**
 * 这个版本比较冗余，但是比较清晰
 */
class TopVotedCandidate_V1 {

    TreeMap<Integer/*用户投票的时间点*/, Integer/*序号*/> map = new TreeMap<>();
    int version = 0;

    class Person {
        int score;
        int version;
        int index;

        public Person(int index) {
            this.index = index;
        }
    }

    public TopVotedCandidate_V1(int[] persons, int[] times) {


        Person[] current = new Person[persons.length];
        for (int i = 0; i < current.length; i++) {
            current[i] = new Person(i);
        }

        for (int i = 0; i < times.length; i++) {
            current[persons[i]].score++;
            current[persons[i]].version = version++;

            //find max
            int id = findMax(current);
            map.put(times[i], id);

        }


    }

    private int findMax(Person[] current) {
        Person result = current[0];
        for (int i = 1; i < current.length; i++) {

            if (current[i].score > result.score) {
                result = current[i];
            } else if (current[i].score == result.score) {
                if (current[i].version > result.version) {
                    result = current[i];
                }
            }
        }
        return result.index;
    }

    public int q(int t) {
        Integer i = map.floorKey(t);
        if (i == null) {
            return map.firstEntry().getValue();
        }
        return map.get(i);
    }
}

public class online_eleciton {
    public static void main(String[] args) {

        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0
        }, new int[]{
                0, 5, 10, 15, 20, 25, 30
        });

        System.out.println(topVotedCandidate.q(3)); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
        System.out.println(topVotedCandidate.q(12)); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
        System.out.println(topVotedCandidate.q(25)); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
        System.out.println(topVotedCandidate.q(15)); // 返回 0
        System.out.println(topVotedCandidate.q(24)); // 返回 0
        System.out.println(topVotedCandidate.q(8)); // 返回 1


    }
}
