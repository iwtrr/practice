// https://school.programmers.co.kr/learn/courses/30/lessons/87390

import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int) (right - left + 1);
        int[] answer = new int[length];

        for (int i = 0; left <= right; i++, left++) {
            int row = (int) (left / n);
            int col = (int) (left % n);

            answer[i] = Math.max(row, col) + 1;
        }

        return answer;
    }
}