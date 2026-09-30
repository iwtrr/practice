// https://school.programmers.co.kr/learn/courses/30/lessons/176962

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<Plan> pq = new PriorityQueue<>(
                Comparator.comparingInt(Plan::start)
        );

        for (String[] plan : plans) {
            pq.offer(new Plan(plan));
        }

        Deque<Plan> stack = new ArrayDeque<>();

        String[] answer = new String[plans.length];

        int i = 0;

        while (!pq.isEmpty()) {
            Plan current = pq.poll();
            Plan next = pq.peek();

            if (next == null) {
                answer[i++] = current.name();
                while (!stack.isEmpty()) {
                    answer[i++] = stack.pop().name();
                }
                break;
            }

            if (current.end() <= next.start()) {
                answer[i++] = current.name();

                int gap = next.start() - current.end();

                while (!stack.isEmpty()) {
                    Plan stopped = stack.pop();
                    if (stopped.playtime() > gap) {
                        stack.push(
                                new Plan(stopped.name(),
                                        stopped.start() + gap,
                                        stopped.playtime() - gap)
                        );
                        break;
                    }
                    answer[i++] = stopped.name();
                    gap -= stopped.playtime();
                }
            } else {
                stack.push(
                        new Plan(
                                current.name(),
                                next.start(),
                                current.end() - next.start()
                        )
                );
            }
        }

        return answer;
    }

    private record Plan(String name, int start, int playtime) {
        public Plan(String[] plan) {
            this(
                    plan[0],
                    Integer.parseInt(plan[1].substring(0, 2)) * 60 + Integer.parseInt(plan[1].substring(3, 5)),
                    Integer.parseInt(plan[2])
            );
        }

        public int end() {
            return start + playtime;
        }
    }
}