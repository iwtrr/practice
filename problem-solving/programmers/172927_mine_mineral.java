// https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.*;

class Solution {
    private final Map<String, Integer> MINERAL_INDEXES = Map.of("diamond", 0, "iron", 1, "stone", 2);
    private final int[][] FATIGUE_CHART = {
            {1,1,1},
            {5,1,1},
            {25,5,1}
    };

    public int solution(int[] picks, String[] minerals) {
        return searchMinFatigue(picks, minerals, 0);
    }

    private int searchMinFatigue(int[] picks, String[] minerals, int current) {
        if (picks[0] + picks[1] + picks[2] == 0 || current >= minerals.length) {
            return 0;
        }

        int minFatigue = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) {
                continue;
            }

            --picks[i];
            int fatigue = calculateFatigue(i, minerals, current) +
                    searchMinFatigue(picks, minerals, current + 5);
            ++picks[i];

            minFatigue = Math.min(minFatigue, fatigue);
        }

        return minFatigue;
    }

    private int calculateFatigue(int pick, String[] minerals, int start) {
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            if (i + start >= minerals.length) {
                return sum;
            }

            String mineral = minerals[i + start];
            int mineralIndex = MINERAL_INDEXES.get(mineral);

            sum += FATIGUE_CHART[pick][mineralIndex];
        }

        return sum;
    }
}