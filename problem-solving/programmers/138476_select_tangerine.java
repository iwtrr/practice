// https://school.programmers.co.kr/learn/courses/30/lessons/138476

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countBySize = new HashMap<>();

        for (int size : tangerine) {
            countBySize.merge(size, 1, Integer::sum);
        }

        List<Integer> counts = new ArrayList<>(countBySize.values());
        counts.sort(Collections.reverseOrder());

        int answer = 0;

        for (int count : counts) {
            k -= count;
            ++answer;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}