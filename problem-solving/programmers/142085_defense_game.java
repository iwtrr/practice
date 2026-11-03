// https://school.programmers.co.kr/learn/courses/30/lessons/142085

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int i = 0;
        for (; i < enemy.length; i++) {
            if (n - enemy[i] >= 0) {
                pq.add(enemy[i]);
                n -= enemy[i];
            } else {
                if (k == 0) {
                    break;
                }
                --k;

                if (!pq.isEmpty() && pq.peek() >= enemy[i]) {
                    n += pq.poll();
                    --i;
                }
            }
        }

        return i;
    }
}