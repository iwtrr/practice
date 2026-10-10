// https://school.programmers.co.kr/learn/courses/30/lessons/132265

import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        int[] bCount = new int[10001];

        for (int i = 0; i < toppings.length; i++) {
            setB.add(toppings[i]);
            ++bCount[toppings[i]];
        }

        int count = 0;

        for (int topping : toppings) {
            setA.add(topping);
            --bCount[topping];

            if (bCount[topping] == 0) {
                setB.remove(topping);
            }

            if (setA.size() == setB.size()) {
                ++count;
            }
        }

        return count;
    }
}