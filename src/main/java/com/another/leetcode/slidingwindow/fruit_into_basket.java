package com.another.leetcode.slidingwindow;

import java.util.HashMap;

public class fruit_into_basket {
    public static int totalFruit(int[] fruits) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int left=0,right=0,max=0;
        while(right<fruits.length){

            Integer tmp = map.get(fruits[right]);
            if(tmp!=null){
                map.put(fruits[right],tmp+1);
                max=Math.max(max,right-left+1);
                right++;
            }else{
                if(map.size()==2){
                    while(map.size()==2){
                        int tmp2 = map.get(fruits[left]);
                        if(tmp2==1){
                            map.remove(fruits[left]);
                            left++;
                            break;
                        }else{
                            map.put(fruits[left],tmp2-1);
                            left++;
                        }
                    }
                    map.put(fruits[right],1);
                    max=Math.max(max,right-left+1);
                    right++;

                }else{
                    map.put(fruits[right],1);
                    max=Math.max(max,right-left+1);
                    right++;
                }
            }

        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,2,3,2,2,2,3,4,4,4,4,4,4,4,4,5,5,6,1,1,2,2,2,2,2,2,2,3,3,3,1,1,1,1,1,1,2,2,2,1,1,1,2,2,2,3,3,3,3,3}));
    }
}
