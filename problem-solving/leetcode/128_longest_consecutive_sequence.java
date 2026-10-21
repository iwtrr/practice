// https://leetcode.com/problems/longest-consecutive-sequence

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int length = 1;

            int cur = num;
            while (set.contains(++cur)) {
                ++length;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}