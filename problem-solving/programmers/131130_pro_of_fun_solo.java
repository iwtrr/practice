// https://school.programmers.co.kr/learn/courses/30/lessons/131130

import java.util.*;

class Solution {
    public int solution(int[] cards) {
        List<Integer> boxSizes = new ArrayList<>();
        boolean[] visited = new boolean[101];

        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) {
                continue;
            }

            int boxSize = 0;
            int p = i;

            while (!visited[p]) {
                visited[p] = true;
                ++boxSize;
                p = cards[p] - 1;
            }

            boxSizes.add(boxSize);
        }

        boxSizes.sort(Collections.reverseOrder());

        return boxSizes.size() > 1
                ? boxSizes.get(0) * boxSizes.get(1)
                : 0;
    }
}