// https://school.programmers.co.kr/learn/courses/30/lessons/49994

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        Node node = new Node(0, 0);
        Set<Set<Node>> edgeSet = new HashSet<>();

        for (char dir : dirs.toCharArray()) {
            Node next = node.next(dir);

            if (next == null) {
                continue;
            }

            edgeSet.add(Set.of(node, next));

            node = next;
        }

        return edgeSet.size();
    }

    private record Node(int x, int y) {
        private Node next(char dir) {
            int nx = x;
            int ny = y;

            switch (dir) {
                case 'L' -> --nx;
                case 'R' -> ++nx;
                case 'U' -> --ny;
                case 'D' -> ++ny;
            }

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                return null;
            }

            return new Node(nx, ny);
        }
    }
}