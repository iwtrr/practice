// https://school.programmers.co.kr/learn/courses/30/lessons/67259

import java.util.*;

class Solution {
    public int solution(int[][] board) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::cost));
        int n = board.length;

        int[][][] dist = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        Arrays.fill(dist[0][0], 0);

        pq.offer(new Node(0, 0, 0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int r = current.row();
            int c = current.col();
            int cost = current.cost();
            int direction = current.direction();

            if (cost > dist[r][c][direction]) {
                continue;
            }

            if (r == n - 1 && c == n - 1) {
                break;
            }

            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 ||
                        nr >= n || nc >= n ||
                        board[nr][nc] == 1) {
                    continue;
                }

                int nextCost = cost + 100;
                boolean isCorner = i / 2 != direction / 2;
                boolean isStart = r == 0 && c == 0;
                if (isCorner && !isStart) {
                    nextCost += 500;
                }

                if (nextCost < dist[nr][nc][i]) {
                    dist[nr][nc][i] = nextCost;
                    pq.offer(new Node(nr, nc, nextCost, i));
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dist[n - 1][n - 1][i]);
        }

        return answer;
    }

    private record Node(
            int row,
            int col,
            int cost,
            int direction
    ) { }
}