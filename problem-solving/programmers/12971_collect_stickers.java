// https://school.programmers.co.kr/learn/courses/30/lessons/12971

class Solution {
    public int solution(int sticker[]) {
        if (sticker.length <= 3) {
            int max = 0;

            for (int i = 0; i < sticker.length; i++) {
                max = Math.max(max, sticker[i]);
            }

            return max;
        }

        return Math.max(calculate(sticker, 0, sticker.length - 1), calculate(sticker, 1, sticker.length));
    }

    private int calculate(int[] sticker, int start, int end) {
        int[] dp = new int[sticker.length];

        dp[start] = sticker[start];
        dp[start + 1] = sticker[start + 1];
        dp[start + 2] = sticker[start] + sticker[start + 2];

        for (int i = start + 3; i < end; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + sticker[i];
        }

        return Math.max(dp[end - 2], dp[end - 1]);
    }
}