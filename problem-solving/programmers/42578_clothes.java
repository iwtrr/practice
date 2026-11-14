// https://school.programmers.co.kr/learn/courses/30/lessons/42578

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> counts = new HashMap<>();
        for (String[] c : clothes) {
            counts.merge(c[1], 1, Integer::sum);
        }

        int answer = 1;
        for (int count : counts.values()) {
            answer *= (count + 1);
        }

        --answer;

        return answer;
    }
}