// https://school.programmers.co.kr/learn/courses/30/lessons/42584

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            answer[i] = n - i - 1;

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }

            stack.push(i);
        }

        return answer;
    }
}