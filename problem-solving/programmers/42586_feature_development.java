// https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;

        List<Integer> deploys = new ArrayList<>();

        int deployDay = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int workDay = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

            if (deployDay >= workDay) {
                ++count;
            } else {
                if (count > 0) {
                    deploys.add(count);
                }

                deployDay = workDay;
                count = 1;
            }
        }

        deploys.add(count);

        return deploys.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}