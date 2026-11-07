// https://school.programmers.co.kr/learn/courses/30/lessons/118668

import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;

        for (int i = 0; i < problems.length; i++) {
            problems[i][0] = Math.max(problems[i][0] - alp, 0);
            maxAlp = Math.max(maxAlp, problems[i][0]);

            problems[i][1] = Math.max(problems[i][1] - cop, 0);
            maxCop = Math.max(maxCop, problems[i][1]);
        }

        int[][] minTimes = new int[maxAlp + 1][maxCop + 1];

        for (int[] minTime : minTimes) {
            Arrays.fill(minTime, Integer.MAX_VALUE);
        }
        minTimes[0][0] = 0;

        for (int a = 0; a <= maxAlp; a++) {
            for (int c = 0; c <= maxCop; c++) {
                if (a < maxAlp) {
                    minTimes[a + 1][c] = Math.min(minTimes[a + 1][c], minTimes[a][c] + 1);
                }
                if (c < maxCop) {
                    minTimes[a][c + 1] = Math.min(minTimes[a][c + 1], minTimes[a][c] + 1);
                }

                for (int[] problem : problems) {
                    if (a < problem[0] || c < problem[1]) {
                        continue;
                    }

                    int nextAlp = Math.min(a + problem[2], maxAlp);
                    int nextCop = Math.min(c + problem[3], maxCop);

                    minTimes[nextAlp][nextCop] = Math.min(minTimes[nextAlp][nextCop], minTimes[a][c] + problem[4]);
                }
            }
        }

        return minTimes[maxAlp][maxCop];
    }
}