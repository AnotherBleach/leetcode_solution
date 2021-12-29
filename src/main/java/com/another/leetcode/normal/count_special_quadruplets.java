package com.another.leetcode.normal;

public class count_special_quadruplets {
    public int countQuadruplets(int[] nums) {
        int ans = 0;
        int[] cnt = new int[400];
        for (int c = nums.length - 2; c >=2; c--)
        {
            cnt[nums[c + 1]]++;
            for (int a = 0; a < nums.length; a++)
            {
                for (int b = a + 1; b < c; b++)
                {
                    ans += cnt[nums[a] + nums[b] + nums[c]];
                }
            }
        }

        return ans;

    }
}
