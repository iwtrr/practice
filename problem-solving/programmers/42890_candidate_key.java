// https://school.programmers.co.kr/learn/courses/30/lessons/42890

import java.util.*;

class Solution {
    public int solution(String[][] relation) {

        List<List<Integer>> uniqueKeys = new ArrayList<>();

        findUniqueKeys(relation, 0, new ArrayList<>(), uniqueKeys);

        List<List<Integer>> uniqueKeysCopy = new ArrayList<>(uniqueKeys);

        for (List<Integer> keys : uniqueKeysCopy) {
            uniqueKeys.removeIf(other->!other.equals(keys) && other.containsAll(keys));
        }

        return uniqueKeys.size();
    }

    private void findUniqueKeys(String[][] relation, int index, List<Integer> columns, List<List<Integer>> uniqueKeys) {
        if (!columns.isEmpty() && isUnique(relation, columns)) {
            uniqueKeys.add(new ArrayList<>(columns));
            return;
        }

        for (int i = index; i < relation[0].length; i++) {
            columns.add(i);
            findUniqueKeys(relation,i + 1, columns, uniqueKeys);
            columns.removeLast();
        }
    }

    private boolean isUnique(String[][] relation, List<Integer> columns) {
        Set<String> tuples = new HashSet<>();

        for (String[] rowData : relation) {
            StringBuilder tuple = new StringBuilder();

            for (int column : columns) {
                tuple.append(rowData[column]).append('|');
            }

            if (tuples.contains(tuple.toString())) {
                return false;
            }

            tuples.add(tuple.toString());
        }

        return true;
    }
}