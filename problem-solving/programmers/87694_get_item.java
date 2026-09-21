// https://school.programmers.co.kr/learn/courses/30/lessons/87694

import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = buildPerimeter(rectangle);
        boolean[][] visited = new boolean[102][102];

        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(characterX * 2, characterY * 2, 0));
        visited[characterX * 2][characterY * 2] = true;

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int distance = node.distance;

            if (x == itemX * 2 && y == itemY * 2) {
                return distance / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, distance + 1));
                }
            }
        }

        return -1;
    }

    private int[][] buildPerimeter(int[][] rectangle) {
        int[][] map = new int[102][102];

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 0;
                }
            }
        }

        return map;
    }

    private record Node(int x, int y, int distance) { }
}