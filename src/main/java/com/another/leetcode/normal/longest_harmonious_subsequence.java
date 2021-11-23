package com.another.leetcode.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longest_harmonious_subsequence {

    // 双指针
    public int findLHS2(int[] nums) {

        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = 1; j < nums.length; ) {

            while (j < nums.length && nums[j] - nums[i] == 0) j++;
            if(j==nums.length)return ans;

            if(nums[j]-nums[i]!=1){
                i=j;
                j=j+1;
            }else{
                int q=j;
                while(j<nums.length && nums[j]-nums[i]==1)j++;
                ans=Math.max(ans,j-i);
                i=q;
            }

        }
        return ans;
    }

    // hash计数
    public int findLHS(int[] nums) {

        Map<Integer, Integer> data = new HashMap<>();
        for (int x : nums) {
            data.put(x, data.getOrDefault(x, 0) + 1);
        }
        int small = 0, big = 0;
        int maxLength = 0;
        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {

            int key = entry.getKey();
            int valueSmall = entry.getValue();
            if (data.get(key + 1) == null) continue;
            int valueBig = data.get(key + 1);
            if (valueSmall + valueBig > maxLength) {
                maxLength = valueBig + valueSmall;
                small = key;
                big = key + 1;
            }

        }
        return small == big ? 0 : data.get(small) + data.get(big);

    }

    public static void main(String[] args) {
        System.out.printf(Integer.toBinaryString(27));
        //System.out.println(new longest_harmonious_subsequence().findLHS2(new int[]{3,2,2,3,2,1,3,3,3,-2,0,3,2,1,0,3,1,0,1,3,0,3,3}));
    }
}
