// https://school.programmers.co.kr/learn/courses/30/lessons/87946

import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        return count(k, dungeons, 0, new boolean[dungeons.length]);
    }

    private int count(int k, int[][] dungeons, int count, boolean[] visited) {
        int max = count;

        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0], fatigue = dungeons[i][1];

            if (visited[i] || need > k) {
                continue;
            }

            visited[i] = true;
            max = Math.max(max, count(k - fatigue, dungeons, count + 1, visited));
            visited[i] = false;
        }

        return max;
    }
}