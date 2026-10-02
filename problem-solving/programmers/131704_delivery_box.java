// https://school.programmers.co.kr/learn/courses/30/lessons/131704

import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();

        int box = 1;
        int count = 0;

        for (int o : order) {
            if (box > o) {
                if (!stack.isEmpty() && stack.peek() == o) {
                    stack.pop();
                    ++count;
                    continue;
                }

                break;
            }

            while (box < o) {
                stack.push(box++);
            }

            if (box == o) {
                ++count;
                ++box;
            }
        }

        return count;
    }
}