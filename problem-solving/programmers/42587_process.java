// https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Process> queue = new ArrayDeque<>();
        int[] priorityCounts = new int[10];
        int highestPriority = 0;

        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];

            queue.offer(new Process(priority, i));
            ++priorityCounts[priority];
            highestPriority = Math.max(highestPriority, priority);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            Process process = queue.poll();
            int priority = process.priority();

            if (priority < highestPriority) {
                queue.offer(process);
                continue;
            }

            ++count;
            if (process.location == location) {
                return count;
            }

            --priorityCounts[priority];
            while (highestPriority > 0 && priorityCounts[highestPriority] == 0) {
                --highestPriority;
            }
        }

        return count;
    }

    private record Process(int priority, int location) {}
}