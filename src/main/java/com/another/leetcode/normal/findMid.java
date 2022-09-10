package com.another.leetcode.normal;

import java.util.PriorityQueue;

public class findMid {
    PriorityQueue<Integer> minPrioQueue;
    PriorityQueue<Integer> maxPrioQueue;
    int size=0;


    public findMid() {
        minPrioQueue = new PriorityQueue<>();
        maxPrioQueue = new  PriorityQueue<>((x1,x2)->{return x2-x1;});
    }

    public void addNum(int num) {

        size++;
        if(size==1){
            minPrioQueue.add(num);
            return;
        }

        if(size%2==1){
            if(minPrioQueue.peek()>num){
                maxPrioQueue.add(num);
                int big=maxPrioQueue.poll();
                minPrioQueue.add(big);
            }else{
                minPrioQueue.add(num);
            }

        }else{

            if(minPrioQueue.peek()<num){

                int big=minPrioQueue.poll();
                maxPrioQueue.add(big);
                minPrioQueue.add(num);
            }else{
                maxPrioQueue.add(num);
            }

        }

    }

    public double findMedian() {
        if(size==0) return -1;

        if(size%2==1)
            return  minPrioQueue.peek();

        return (maxPrioQueue.peek()+minPrioQueue.peek())/2.0;
    }

    public static void main(String[] args) {
        findMid s = new findMid();
        s.addNum(6);
        System.out.println(s.findMedian());
        s.addNum(10);
        System.out.println(s.findMedian());
        s.addNum(2);
        System.out.println(s.findMedian());
    }
}
