package com.another.leetcode.simulation;

public class baseBall_game {
    public int calPoints(String[] ops) {

        int[]total = new int[ops.length+10];
        int size=0;
        int sum=0;

        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C")){
                size--;
            }else if(ops[i].equals("D")){
                total[size]=total[size-1]*2;
                size++;
            }else if(ops[i].equals("+")){
                total[size]=total[size-1]+total[size-2];
                size++;
            }else{
                total[size]=Integer.valueOf(ops[i]);
                size++;
            }
        }
        for(int i=0;i<size;i++)sum+=total[i];
        return sum;
    }
}
