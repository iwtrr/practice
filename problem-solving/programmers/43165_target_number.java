// https://school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    public int solution(int[] numbers, int target) {
        return sumTo(numbers, target, 0, 0);
    }

    private int sumTo(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }

        return sumTo(numbers, target, index + 1, sum + numbers[index]) +
                sumTo(numbers, target, index + 1, sum - numbers[index]);
    }
}