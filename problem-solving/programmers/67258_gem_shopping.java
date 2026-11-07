// https://school.programmers.co.kr/learn/courses/30/lessons/67258

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, Integer.MAX_VALUE};

        int gemTypeCount = new HashSet<>(Arrays.asList(gems)).size();

        Map<String, Integer> gemCounts = new HashMap<>();
        for (int l = 0, r = 0; r < gems.length; r++) {
            gemCounts.merge(gems[r], 1, Integer::sum);

            while (gemCounts.size() == gemTypeCount) {
                if (answer[1] - answer[0] > r - l) {
                    answer[0] = l + 1;
                    answer[1] = r + 1;
                }

                gemCounts.computeIfPresent(gems[l++], (k, v) -> v - 1 == 0 ? null : v - 1);
            }
        }

        return answer;
    }
}