// https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int out = -30001;

        for (int[] route : routes) {
            if (out < route[0]) {
                answer += 1;
                out = route[1];
            }
        }

        return answer;
    }
}