// https://school.programmers.co.kr/learn/courses/30/lessons/389479

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        int[] n = new int[24];

        for (int i = 0; i < 24; i++) {
            int required = players[i] / m;

            if (n[i] >= required) {
                continue;
            }

            int needs = required - n[i];

            for (int j = i; j < i + k && j < 24; j++) {
                n[j] += needs;
            }

            answer += needs;
        }

        return answer;
    }
}