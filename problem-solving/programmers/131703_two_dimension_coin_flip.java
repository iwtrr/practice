// https://school.programmers.co.kr/learn/courses/30/lessons/131703

class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int flipCount = simulate(beginning, target, false);
        int flipCountWithFirstRowFlip = simulate(beginning, target, true);

        int answer = Math.min(flipCount, flipCountWithFirstRowFlip);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int simulate(int[][] beginning, int[][] target, boolean flipFirstRow) {
        int n = beginning.length;
        int m = beginning[0].length;

        int[][] diff = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = beginning[i][j] ^ target[i][j];
            }
        }

        int count = 0;

        if (flipFirstRow) {
            for (int i = 0; i < m; i++) {
                diff[0][i] ^= 1;
            }
            count += 1;
        }

        for (int i = 0; i < m; i++) {
            if (diff[0][i] == 1) {
                flipColumn(diff, i);
                count += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (diff[i][0] == 1) {
                flipRow(diff, i);
                count += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (diff[i][j] == 1) {
                    return Integer.MAX_VALUE;
                }
            }
        }

        return count;
    }

    private void flipColumn(int[][] matrix, int index) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][index] ^= 1;
        }
    }

    private void flipRow(int[][] matrix, int index) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[index][i] ^= 1;
        }
    }
}