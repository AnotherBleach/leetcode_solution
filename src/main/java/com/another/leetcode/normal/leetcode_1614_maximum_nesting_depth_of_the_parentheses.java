package com.another.leetcode.normal;

public class leetcode_1614_maximum_nesting_depth_of_the_parentheses {
    public int maxDepth(String s) {
        int length = s.length();
        int ans = 0;

        int preC = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                preC++;
                ans = Math.max(preC, ans);
            } else if (c == ')') {
                preC--;
            }

        }
        return ans;
    }
}
