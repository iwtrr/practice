// https://school.programmers.co.kr/learn/courses/30/lessons/42883

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';

            while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                --k;
            }

            stack.push(num);
        }

        while (k > 0) {
            stack.pop();
            --k;
        }

        for (int num : stack) {
            answer.append(num);
        }

        return answer.reverse().toString();
    }
}