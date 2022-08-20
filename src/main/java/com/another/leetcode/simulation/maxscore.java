package com.another.leetcode.simulation;

import java.util.Random;

public class maxscore {
    public int maxScore(String s) {
        int zero = 0,one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')zero++;
            else one++;
        }

        int maxScore=0;

        int currentZero=0,curentOne=one;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                currentZero++;
            }else{
                curentOne--;
            }
            if(curentOne+currentZero>maxScore)
                maxScore=currentZero+curentOne;
        }
        return maxScore;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Random rd= new Random();
        for(int i=0;i<500;i++){
            if(rd.nextInt(2)%2==0)
                sb.append("1");
            else sb.append("0");
        }
        System.out.println(sb.toString());
        System.out.println(new maxscore().maxScore(sb.toString()));
    }
}
