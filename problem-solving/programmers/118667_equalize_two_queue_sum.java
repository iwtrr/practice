// https://school.programmers.co.kr/learn/courses/30/lessons/118667

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;

        Deque<Integer> q1 = new ArrayDeque<>();
        long q1Sum = 0;

        Deque<Integer> q2 = new ArrayDeque<>();
        long q2Sum = 0;

        for (int i = 0; i < n; i++) {
            q1.offer(queue1[i]);
            q1Sum += queue1[i];

            q2.offer(queue2[i]);
            q2Sum += queue2[i];
        }

        long total = q1Sum + q2Sum;

        if (total % 2 == 1) {
            return -1;
        }

        long goal = total / 2;
        
        int count = 0;

        while (count < n * 3) {
            if (q1Sum == goal) {
                return count;
            }
            if (q1Sum < goal) {
                int v = q2.poll();
                q1.offer(v);
                q1Sum += v;
                q2Sum -= v;
            } else {
                int v = q1.poll();
                q2.offer(v);
                q2Sum += v;
                q1Sum -= v;
            }

            ++count;
        }

        return -1;
    }
}