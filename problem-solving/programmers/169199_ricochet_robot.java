// https://school.programmers.co.kr/learn/courses/30/lessons/169199

import java.util.*;

class Solution {
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        int ry = -1, rx = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    ry = i;
                    rx = j;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        Deque<Position> queue = new ArrayDeque<>();

        int[][] distance = new int[n][m];

        visited[ry][rx] = true;
        queue.offer(new Position(ry, rx));

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (board[current.y()].charAt(current.x()) == 'G') {
                return distance[current.y()][current.x()];
            }

            for (Direction direction : Direction.values()) {
                Position next = getNextPosition(board, current, direction);

                if (!visited[next.y()][next.x()]) {
                    visited[next.y()][next.x()] = true;
                    distance[next.y()][next.x()] = distance[current.y()][current.x()] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1;
    }

    private record Position(int y, int x) {}

    private Position getNextPosition(String[] board, Position position, Direction direction) {
        int i = position.y();
        int j = position.x();

        while (true) {
            int nextY = i + direction.dy;
            int nextX = j + direction.dx;

            if (nextY < 0 || nextY >= board.length ||
                    nextX < 0 || nextX >= board[0].length() ||
                    board[nextY].charAt(nextX) == 'D') {
                break;
            }

            i = nextY;
            j = nextX;
        }

        return new Position(i, j);
    }

    private enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int dy, dx;

        Direction(int dy, int dx) {
            this.dy = dy;
            this.dx = dx;
        }
    }
}