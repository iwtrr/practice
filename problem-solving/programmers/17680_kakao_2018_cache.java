// https://school.programmers.co.kr/learn/courses/30/lessons/17680

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Cache cache = new Cache(cacheSize);
        for (String city : cities) {
            String lowerCity = city.toLowerCase();
            if (cache.tryHit(lowerCity)) {
                ++answer;
            } else {
                answer += 5;
            }
        }

        return answer;
    }

    private class Cache {
        private final LinkedHashSet<String> set = new LinkedHashSet<>();
        private int cacheSize = 0;

        public Cache(int cacheSize) {
            this.cacheSize = cacheSize;
        }

        public boolean tryHit(String data) {
            if (cacheSize == 0) {
                return false;
            }

            if (set.remove(data)) {
                set.add(data);

                return true;
            } else {
                if (set.size() == cacheSize) {
                    set.remove(set.iterator().next());
                }
                set.add(data);

                return false;
            }
        }
    }
}