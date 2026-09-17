// https://school.programmers.co.kr/learn/courses/30/lessons/468370

import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int length = message.length();

        boolean[] isSpoilerByIndex = new boolean[length];

        for (int[] range : spoiler_ranges) {
            Arrays.fill(isSpoilerByIndex, range[0], range[1] + 1, true);
        }

        Set<String> nonSpoilerWords = new HashSet<>();
        Set<String> spoilerWords = new HashSet<>();

        for (int i = 0; i < length; i++) {
            if (message.charAt(i) == ' ') continue;

            int j = i;
            boolean isSpoiler = false;
            while (j < length && message.charAt(j) != ' ') {
                if (isSpoilerByIndex[j]) isSpoiler = true;
                ++j;
            }

            String word = message.substring(i, j);

            if (isSpoiler) {
                spoilerWords.add(word);
            } else {
                nonSpoilerWords.add(word);
            }

            i = j;
        }

        int answer = 0;
        for (String spoilerWord : spoilerWords) {
            if (!nonSpoilerWords.contains(spoilerWord)) {
                ++answer;
            }
        }

        return answer;
    }
}