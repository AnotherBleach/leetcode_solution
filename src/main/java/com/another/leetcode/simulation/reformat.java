package com.another.leetcode.simulation;

public class reformat {
}

class Solution111111{
    public String reformat(String s) {
        StringBuilder number = new StringBuilder();
        StringBuilder alpha = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isNumber(c)){
                number.append(c);
            }else{
                alpha.append(c);
            }
        }

        int delta=Math.abs(number.length()-alpha.length());
        if(delta>1)return "";



        StringBuilder sb = new StringBuilder();
        if(delta==0){
            for(int i=0;i<number.length();i++){
                sb.append(number.charAt(i)).append(alpha.charAt(i));
            }
            return sb.toString();
        }
        if(delta==1){
            if(number.length()>alpha.length()){
                StringBuilder tmp = number;
                number=alpha;
                alpha=tmp;
            }
            for(int i=0;i<number.length();i++){
                sb.append(alpha.charAt(i)).append(number.charAt(i));
            }
            sb.append(alpha.charAt(alpha.length()-1));
            return sb.toString();

        }

        return sb.toString();
    }
    public boolean isNumber(char c){
        return c>='0' && c<='9';
    }
}