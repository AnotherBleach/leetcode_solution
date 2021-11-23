package com.another.leetcode.normal;

public class buddy_strings {
    public boolean buddyStrings(String s, String goal) {

        if(s.length()!=goal.length())return false;

        int len=s.length();
        int count=0,dif1=0,dif2=0;
        int[] c = new int[26];
        char[] sArray = s.toCharArray();
        char[] goalArray = goal.toCharArray();

        for(int i=0;i<len;i++){

            c[sArray[i]-'a']++;

            if(sArray[i]!=goalArray[i]){
                count++;
                if(count>2)return false;

                if(count==1)dif1=i;
                else dif2=i;
            }
        }
        // 特殊情况
        if(count==0){
            for(int i=0;i<26;i++){
                if(c[i]>1)return true;
            }
            return false;

        }
        if(count!=2)return false;

        return (sArray[dif1]==goalArray[dif2] && sArray[dif2]==goalArray[dif1]);

    }
}
