// https://school.programmers.co.kr/learn/courses/30/lessons/12987

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        for (int ap = A.length - 1, bp = B.length - 1; ap >= 0; ap--, bp--) {
            while (ap >= 0 && A[ap] >= B[bp]) {
                --ap;
            }

            if (ap == -1) {
                break;
            }

            ++answer;
        }

        return answer;
    }
}