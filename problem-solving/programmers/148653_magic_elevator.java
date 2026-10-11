// https://school.programmers.co.kr/learn/courses/30/lessons/148653

class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int r = storey % 10;

            if (r > 5) {
                r = 10 - r;
            } else if (r == 5) {
                r = storey / 10 % 10 >= 5 ? 5 : -5;
            } else if (r < 5) {
                r = -r;
            }

            storey = (storey + r) / 10;
            answer += Math.abs(r);
        }

        return answer;
    }
}