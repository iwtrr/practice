// https://school.programmers.co.kr/learn/courses/30/lessons/72411

import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] orders, int[] courseSizes) {
        Map<String, Integer> courseCounts = new HashMap<>();
        int[] maxCount = new int[11];

        for (String order : orders) {
            Set<String> set = subset(order, courseSizes);

            for (String course : set) {
                int count = courseCounts.getOrDefault(course, 0) + 1;
                courseCounts.put(course, count);
                maxCount[course.length()] = Math.max(maxCount[course.length()], count);
            }
        }

        TreeSet<String> answer = new TreeSet<>();

        for (Map.Entry<String, Integer> courseCount : courseCounts.entrySet()) {
            String course = courseCount.getKey();
            int count = courseCount.getValue();

            if (count > 1 && count == maxCount[course.length()]) {
                answer.add(course);
            }
        }

        return answer.toArray(new String[0]);
    }

    private Set<String> subset(String order, int[] course) {
        Set<String> result = new HashSet<>();
        Set<Integer> resultSizes = IntStream.of(course).boxed().collect(Collectors.toSet());
        char[] menus = order.toCharArray();
        int boundary = IntStream.of(course).max().getAsInt();

        Arrays.sort(menus);
        subset(result, resultSizes, menus, 0, new StringBuilder(), boundary);

        return result;
    }

    private void subset(Set<String> result, Set<Integer> resultSizes, char[] menus, int idx, StringBuilder selected, int boundary) {
        if (resultSizes.contains(selected.length())) {
            result.add(selected.toString());
        }

        if (selected.length() >= boundary) {
            return;
        }

        for (int i = idx; i < menus.length; i++) {
            selected.append(menus[i]);
            subset(result, resultSizes, menus, i + 1, selected, boundary);
            selected.setLength(selected.length() - 1);
        }
    }
}