// https://school.programmers.co.kr/learn/courses/30/lessons/160585

class Solution {
    public int solution(String[] board) {
        int oCount = 0, xCount = 0;

        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'O') {
                    ++oCount;
                }
                if (c == 'X') {
                    ++xCount;
                }
            }
        }

        boolean isNormal = (oCount == xCount && !isWin(board, 'O'))
                || (oCount == xCount + 1 && !isWin(board, 'X'));

        return isNormal ? 1 : 0;
    }

    private boolean isWin(String[] board, char c) {
        boolean diagMade = true, antiDiagMade = true;

        for (int i = 0; i < 3; i++) {
            boolean rowMade = true, colMade = true;

            for (int j = 0; j < 3; j++) {
                rowMade &= board[i].charAt(j) == c;
                colMade &= board[j].charAt(i) == c;
            }

            if (rowMade || colMade) {
                return true;
            }

            diagMade &= board[i].charAt(i) == c;
            antiDiagMade &= board[i].charAt(2 - i) == c;
        }

        return diagMade || antiDiagMade;
    }
}