package com.another.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class minimal_window_substr {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        HashMap<Character,Integer>t_map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            int tmp = t_map.getOrDefault(t.charAt(i),0);
            t_map.put(t.charAt(i),tmp+1);
        }


        int s_len=s.length();
        HashMap<Character,Integer>s_map = new HashMap<>();
        int left=0,right=0,start=-1,stop=-1,minLen=Integer.MAX_VALUE;

        while(right<s_len){

            char c=s.charAt(right);
            int tmp=s_map.getOrDefault(c,0);
            s_map.put(c,tmp+1);

            if(isOk(s_map,t_map)){

                if(minLen>right-left+1){

                    start=left;
                    stop=right;
                    minLen=right-left+1;
                }

                while(isOk(s_map,t_map)){

                    if(minLen>right-left+1){

                        start=left;
                        stop=right;
                        minLen=right-left+1;
                    }

                    char left_char = s.charAt(left);
                    int cur=s_map.get(left_char);
                    s_map.put(left_char,cur-1);
                    left++;


                }
                right++;

            }else{

                right++;
            }



        }

        StringBuilder sb = new StringBuilder();
        if(start<0)return "";
        for(int i=start;i<=stop;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public boolean isOk(HashMap<Character,Integer>s_map,HashMap<Character,Integer>t_map){
        for(Map.Entry<Character,Integer>entry: t_map.entrySet()){

            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(s_map.getOrDefault(key,0)<value){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new minimal_window_substr().minWindow("ADOBECODEBANC","ABC"));
    }
}
