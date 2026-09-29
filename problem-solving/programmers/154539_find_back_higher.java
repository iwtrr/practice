// https://school.programmers.co.kr/learn/courses/30/lessons/154539

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;

        int[] answer = new int[len];

        Deque<Integer> stack = new ArrayDeque();

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(numbers[i]);
        }

        return answer;
    }
}