// https://school.programmers.co.kr/learn/courses/30/lessons/92342

import java.util.*;
import java.util.stream.*;

class Solution {
    private int[] answer = {-1};
    private int bestDiff = 0;

    public int[] solution(int n, int[] apeachShoots) {
        simulate(n, apeachShoots, new int[11], 0, 10);

        return answer;
    }

    private void simulate(int n, int[] apeachShoots, int[] ryanShoots, int ryanShootCount, int k) {
        int restShoot = n - ryanShootCount;

        if (k == 0) {
            ryanShoots[10] = restShoot;

            if (isBestShoots(apeachShoots, ryanShoots)) {
                answer = Arrays.copyOf(ryanShoots, ryanShoots.length);
            }

            return;
        }

        int i = 10 - k;
        if (apeachShoots[i] < restShoot) {
            ryanShoots[i] = apeachShoots[i] + 1;
            simulate(n, apeachShoots, ryanShoots, ryanShootCount + ryanShoots[i], k - 1);
        }

        ryanShoots[i] = 0;
        simulate(n, apeachShoots, ryanShoots, ryanShootCount, k - 1);
    }

    private boolean isBestShoots(int[] apeachShoots, int[] ryanShoots) {
        int apeachGrade = 0;
        int ryanGrade = 0;

        for (int i = 0; i < 10; i++) {
            if (apeachShoots[i] == ryanShoots[i] && apeachShoots[i] == 0) {
                continue;
            }

            if (apeachShoots[i] < ryanShoots[i]) {
                ryanGrade += 10 - i;
            } else {
                apeachGrade += 10 - i;
            }
        }

        int diff = ryanGrade - apeachGrade;
        if (diff <= 0) {
            return false;
        }

        if (diff > bestDiff) {
            bestDiff = diff;

            return true;
        } else if (diff == bestDiff) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] == ryanShoots[i]) {
                    continue;
                }

                return ryanShoots[i] - answer[i] > 0;
            }
        }

        return false;
    }
}