// https://school.programmers.co.kr/learn/courses/30/lessons/154538

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            int[] nextIdxs = { i + n, i * 2, i * 3 };

            for (int j : nextIdxs) {
                if (j > y) {
                    continue;
                }

                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        return dp[y] != Integer.MAX_VALUE ? dp[y] : -1;
    }
}