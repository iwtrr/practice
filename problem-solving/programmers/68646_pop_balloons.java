// https://school.programmers.co.kr/learn/courses/30/lessons/68646

class Solution {
    public int solution(int[] a) {
        int[] rightMins = new int[a.length];

        rightMins[a.length - 1] = Integer.MAX_VALUE;
        for (int i = a.length - 1; i > 0; i--) {
            rightMins[i - 1] = Math.min(rightMins[i], a[i]);
        }

        int answer = a.length;

        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (leftMin < a[i] && a[i] > rightMins[i]) {
                --answer;
            }

            leftMin = Math.min(leftMin, a[i]);
        }

        return answer;
    }
}