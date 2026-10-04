// https://school.programmers.co.kr/learn/courses/30/lessons/86971

import java.util.*;

class Solution {
    private int minDiff;

    public int solution(int n, int[][] wires) {
        minDiff = Integer.MAX_VALUE;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        countSubTree(graph, 1, 0);

        return minDiff;
    }

    private int countSubTree(List<List<Integer>> graph, int current, int parent) {
        int n = graph.size() - 1;

        int subTreeCount = 1;

        for (int next : graph.get(current)) {
            if (next == parent) {
                continue;
            }

            int count = countSubTree(graph, next, current);
            int diff = Math.abs(count - (n - count));

            minDiff = Math.min(minDiff, diff);

            subTreeCount += count;

        }

        return subTreeCount;
    }
}