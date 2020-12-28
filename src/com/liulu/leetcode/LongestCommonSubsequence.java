package com.liulu.leetcode;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0)
            return 0;
        int length1 = text1.length();
        int length2 = text2.length();
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] dp = new int[length1 + 1][length2 + 2];

        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                if (ch1[i - 1] == ch2[j -1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[length1][length2];
    }
}
