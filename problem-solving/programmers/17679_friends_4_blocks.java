// https://school.programmers.co.kr/learn/courses/30/lessons/17679

import java.util.*;

class Solution {
    private final static int[] DY = {0,0,1,1};
    private final static int[] DX = {0,1,0,1};

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] boardData = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            boardData[i] = board[i].toCharArray();
        }

        int tryRemove = -1;
        while (tryRemove != 0) {
            tryRemove = removeSets(boardData);
            answer += tryRemove;
        }

        return answer;
    }

    private int removeSets(char[][] board) {
        Set<Position> willDelete = new HashSet<>();

        for (int y = 0; y < board.length - 1; y++) {
            for (int x = 0; x < board[0].length - 1; x++) {
                if (!canRemove(board, y, x)) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    willDelete.add(new Position(y + DY[i], x + DX[i]));
                }
            }
        }

        int count = willDelete.size();

        for (Position delete : willDelete) {
            board[delete.y()][delete.x()] = ' ';
        }

        for (int x = 0; x < board[0].length; x++) {
            int y = board.length - 1;

            for (int p = y; p >= 0; p--) {
                if (board[p][x] == ' ') {
                    continue;
                }

                board[y--][x] = board[p][x];
            }

            while (y >= 0) {
                board[y--][x] = ' ';
            }
        }

        return count;
    }

    private boolean canRemove(char[][] board, int y, int x) {
        char c = board[y][x];

        if (c == ' ') {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (board[y + DY[i]][x + DX[i]] != c) {
                return false;
            }
        }

        return true;
    }

    private record Position(int y, int x) {}
}