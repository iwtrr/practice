// https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;

class Solution {
    private final static int[] DR = {-1, 1, 0, 0};
    private final static int[] DC = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        int[] oilByColumn = new int[m];

        Queue<Node> queue = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (land[r][c] == 0) {
                    continue;
                }

                Set<Integer> columns = new HashSet<>();

                int oilAmount = 0;

                land[r][c] = 0;
                queue.offer(new Node(r, c));

                while (!queue.isEmpty()) {
                    Node current = queue.poll();

                    ++oilAmount;

                    columns.add(current.col());

                    for (int i = 0; i < 4; i++) {
                        int nr = current.row() + DR[i];
                        int nc = current.col() + DC[i];

                        boolean isVisitable =
                                0 <= nr && nr < n &&
                                        0 <= nc && nc < m &&
                                        land[nr][nc] == 1;

                        if (isVisitable) {
                            land[nr][nc] = 0;
                            queue.offer(new Node(nr, nc));
                        }
                    }
                }

                for (Integer col : columns) {
                    oilByColumn[col] += oilAmount;
                }
            }
        }

        int max = 0;

        for (int oil : oilByColumn) {
            max = Math.max(max, oil);
        }

        return max;
    }

    private record Node(int row, int col) {}
}