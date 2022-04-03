package com.another.leetcode.binarySearch;

public class find_smallest_letter_g_than_target {

    public char nextGreatestLetter(char[] letters, char target) {
        int start=0,stop=letters.length-1;
        while(start<=stop){

            int mid=(start+stop)/2;
            char c= letters[mid];
            if(c==target){
                while(c==target){
                    mid=mid+1;
                    if(mid>=letters.length)return letters[0];
                    c=letters[mid];
                }
                return c;
            }else if(c>target){
                stop=mid-1;
            }else{
                start=mid+1;
            }
        }


        return letters[start%letters.length];
    }



    public char nextGreatestLetterV2(char[] letters, char target) {
        int start=0,stop=letters.length-1;
        while(start<=stop){

            int mid=(start+stop)/2;
            char c= letters[mid];
            if(c==target){
                if(mid+1<letters.length){
                    if(letters[mid+1]>c)return letters[mid+1];
                    start=mid+1;
                }else{
                    return letters[0];
                }
            }else if(c>target){
                stop=mid-1;
            }else{
                start=mid+1;
            }
        }


        return letters[start%letters.length];
    }
}
