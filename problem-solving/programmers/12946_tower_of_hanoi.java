// https://school.programmers.co.kr/learn/courses/30/lessons/12946

import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();

        hanoi(n, 1, 3, 2, moves);

        return moves.toArray(int[][]::new);
    }

    private void hanoi(int n, int from, int to, int via, List<int[]> moves) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, via, to, moves);

        moves.add(new int[]{from, to});

        hanoi(n - 1, via, to, from, moves);
    }
}