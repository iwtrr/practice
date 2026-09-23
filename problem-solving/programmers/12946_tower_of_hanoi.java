// https://school.programmers.co.kr/learn/courses/30/lessons/12946

import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> logs = hanoi(n, 1, 3, 2, new ArrayList<>());

        return logs.toArray(new int[logs.size()][]);
    }

    public List<int[]> hanoi(int n, int from, int to, int via, List<int[]> logs) {
        if (n == 1) {
            logs.add(new int[]{ from, to });
            return logs;
        }

        hanoi(n - 1, from, via, to, logs);

        logs.add(new int[]{ from, to });

        hanoi(n - 1, via, to, from, logs);

        return logs;
    }
}