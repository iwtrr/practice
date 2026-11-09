// https://school.programmers.co.kr/learn/courses/30/lessons/12913

import java.util.stream.*;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];

        for (int x = 0; x < 4; x++) {
            dp[0][x] = land[0][x];
        }

        for (int y = 1; y < land.length; y++) {
            for (int x = 0; x < 4; x++) {
                for (int prevX = 0; prevX < 4; prevX++) {
                    if (x == prevX) {
                        continue;
                    }

                    dp[y][x] = Math.max(dp[y][x], dp[y - 1][prevX] + land[y][x]);
                }
            }
        }

        return IntStream.of(dp[land.length - 1]).max().getAsInt();
    }
}