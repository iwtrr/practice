// https://school.programmers.co.kr/learn/courses/30/lessons/67257

import java.util.*;

class Solution {
    private final Set<Character> operatorSet = Set.of('+','-','*');
    private final List<Character> operatorPriorities = new ArrayList<>();
    private long answer = 0;

    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        for (int l = 0, r = 0; l < expression.length(); r++) {
            while (r < expression.length() && !operatorSet.contains(expression.charAt(r))) {
                ++r;
            }

            numbers.add(Long.parseLong(expression.substring(l, r)));
            if (r != expression.length()) {
                operators.add(expression.charAt(r));
            }

            l = r + 1;
        }

        find(numbers, operators);

        return answer;
    }

    private void find(List<Long> numbers, List<Character> operators) {
        if (operatorPriorities.size() == operatorSet.size()) {
            List<Long> targetNumbers = new ArrayList<>(numbers);
            List<Character> restOperations = new ArrayList<>(operators);

            for (Character priorOperator : operatorPriorities) {
                for (int i = 0; i < restOperations.size(); i++) {
                    if (restOperations.get(i).equals(priorOperator)) {
                        targetNumbers.set(i, calculate(targetNumbers.get(i), targetNumbers.get(i + 1), priorOperator));
                        targetNumbers.remove(i + 1);
                        restOperations.remove(i);
                        --i;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(targetNumbers.get(0)));

            return;
        }

        for (Character operator : operatorSet) {
            if (!operatorPriorities.contains(operator)) {
                operatorPriorities.add(operator);
                find(numbers, operators);
                operatorPriorities.remove(operator);
            }
        }
    }

    private long calculate(long a, long b, Character op) {
        if (op.equals('+')) {
            return a + b;
        }
        if (op.equals('-')) {
            return a - b;
        }
        if (op.equals('*')) {
            return a * b;
        }

        return 0;
    }
}