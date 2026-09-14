// https://school.programmers.co.kr/learn/courses/30/lessons/42895

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }

        int repN = N;
        for (int i = 1; i < 9; i++) {
            Set<Integer> nextSubSet = dp.get(i);
            nextSubSet.add(repN);
            repN = repN * 10 + N;

            for (int j = 1; j < i; j++) {
                for (int left : dp.get(j)) {
                    for (int right : dp.get(i - j)) {
                        nextSubSet.add(left + right);
                        nextSubSet.add(left - right);
                        nextSubSet.add(left * right);
                        if (right != 0) {
                            nextSubSet.add(left / right);
                        }
                    }
                }
            }

            if (nextSubSet.contains(number)) {
                return i;
            }
        }

        return -1;
    }
}

public class Solve {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(5, 5));
    }
}