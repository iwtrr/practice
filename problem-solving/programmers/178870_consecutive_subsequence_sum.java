// https://school.programmers.co.kr/learn/courses/30/lessons/178870

import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] result = new int[2];

        int n = sequence.length;
        int sum = 0;
        int minRangeSize = Integer.MAX_VALUE;

        for (int left = 0, right = 0; left < n; left++) {
            while (right < n && sum < k) {
                sum += sequence[right++];
            }

            if (sum == k) {
                int rangeSize = right - left;
                if (minRangeSize > rangeSize) {
                    minRangeSize = rangeSize;
                    result[0] = left;
                    result[1] = right - 1;
                }
            }

            sum -= sequence[left];
        }

        return result;
    }
}