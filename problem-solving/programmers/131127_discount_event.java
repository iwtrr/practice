// https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wants = new HashMap<>();

        int n = 0;

        for (int i = 0; i < want.length; i++) {
            wants.merge(want[i], number[i], Integer::sum);
            n += number[i];
        }

        Map<String, Integer> discounts = new HashMap<>();

        int answer = 0;

        for (int i = 0; i < discount.length; i++) {
            if (i - n >= 0) {
                discounts.merge(discount[i - n], -1, Integer::sum);
            }
            discounts.merge(discount[i], 1, Integer::sum);

            if (discounts.entrySet().containsAll(wants.entrySet())) {
                ++answer;
            }
        }

        return answer;
    }
}