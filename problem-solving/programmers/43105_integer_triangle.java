// https://school.programmers.co.kr/learn/courses/30/lessons/43105
    
class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] sum = new int[n][n];

        sum[0][0] = triangle[0][0];

        for (int y = 0; y < n - 1; y++) {
            for (int x = 0; x < triangle[y].length; x++) {
                sum[y + 1][x] = Math.max(sum[y + 1][x], sum[y][x] + triangle[y + 1][x]);
                sum[y + 1][x + 1] = sum[y][x] + triangle[y + 1][x + 1];
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, sum[n - 1][i]);
        }

        return answer;
    }
}