// https://school.programmers.co.kr/learn/courses/30/lessons/152996

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        int[] counts = new int[1001];

        for (int weight : weights) {
            ++counts[weight];
        }

        for (int weight = 100; weight <= 1000; weight++) {
            long count = counts[weight];

            if (count == 0) {
                continue;
            }

            answer += (count - 1) * count / 2;

            if (weight * 3 % 2 == 0) {
                int pairWeight = weight * 3 / 2;

                if (pairWeight <= 1000) {
                    answer += count * counts[pairWeight];
                }
            }

            if (weight * 2 <= 1000) {
                answer += count * counts[weight * 2];
            }

            if (weight * 4 % 3 == 0) {
                int pairWeight = weight * 4 / 3;

                if (pairWeight <= 1000) {
                    answer += count * counts[pairWeight];
                }
            }
        }

        return answer;
    }
}