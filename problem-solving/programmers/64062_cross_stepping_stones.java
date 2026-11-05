// https://school.programmers.co.kr/learn/courses/30/lessons/64062

class Solution {
    public int solution(int[] stones, int k) {
        int left = 0, right = 200_000_000;

        while (left < right) {
            int mid = (left + right) / 2;

            if (kRangeOccurred(stones, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean kRangeOccurred(int[] stones, int k, int friends) {
        int count = 0;

        for (int stone : stones) {
            if (stone <= friends) {
                ++count;
            } else {
                count = 0;
            }

            if (count == k) {
                return true;
            }
        }

        return false;
    }
}