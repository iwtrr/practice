// https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<BridgeTruck> deque = new ArrayDeque<>();

        int i = 0;
        int currentTime = 1;
        int totalWeight = 0;
        int lastInTime = 0;

        while (i < truck_weights.length) {
            while (deque.peek() != null && deque.peek().outTime() <= currentTime) {
                totalWeight -= deque.poll().weight();
            }

            if (totalWeight + truck_weights[i] <= weight) {
                deque.offer(new BridgeTruck(truck_weights[i], currentTime + bridge_length));
                totalWeight += truck_weights[i++];
                lastInTime = currentTime++;
            } else {
                currentTime = deque.peek().outTime();
            }
        }

        return lastInTime + bridge_length;
    }

    private record BridgeTruck(int weight, int outTime) {}
}