// https://school.programmers.co.kr/learn/courses/30/lessons/72412

import java.util.*;

class Solution {
    public int[] solution(String[] infos, String[] querys) {
        Map<String, List<Integer>> scoresByCondition = new HashMap<>();

        for (String info : infos) {
            String[] tokens = info.split(" ");

            String[] attributes = new String[]{tokens[0], tokens[1], tokens[2], tokens[3]};
            int score = Integer.parseInt(tokens[4]);

            registerScoreCombinations(attributes, score, 0, scoresByCondition);
        }

        for (List<Integer> scores : scoresByCondition.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[querys.length];

        for (int i = 0; i < querys.length; i++) {
            String[] tokens = querys[i].replace(" and ", " ").split(" ");

            String key = String.join("|", tokens[0], tokens[1], tokens[2], tokens[3]);
            int score = Integer.parseInt(tokens[4]);

            List<Integer> scores = scoresByCondition.get(key);
            
            if (scores == null) {
                continue;
            }

            answer[i] = countScoresAtLeast(scores, score);
        }

        return answer;
    }

    private void registerScoreCombinations(String[] attributes, int score, int depth, Map<String, List<Integer>> scoresByAttributs) {
        if (depth == 4) {
            String key = String.join("|", attributes);
            scoresByAttributs
                    .computeIfAbsent(key, k -> new ArrayList<>())
                    .add(score);

            return;
        }

        registerScoreCombinations(attributes, score, depth + 1, scoresByAttributs);

        String temp = attributes[depth];
        attributes[depth] = "-";
        registerScoreCombinations(attributes, score, depth + 1, scoresByAttributs);
        attributes[depth] = temp;
    }

    private int countScoresAtLeast(List<Integer> scores, int score) {
        int left = 0;
        int right = scores.size();

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (scores.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return scores.size() - left;
    }
}