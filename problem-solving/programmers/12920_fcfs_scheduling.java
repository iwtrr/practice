// https://school.programmers.co.kr/learn/courses/30/lessons/12920

class Solution {
    public int solution(int n, int[] cores) {
        if (n <= cores.length) {
            return n;
        }

        int workEndTime = getWorkEndTime(n, cores);

        return getLastWorkCoreIndex(n, cores, workEndTime);
    }

    private int getWorkEndTime(int n, int[] cores) {
        int left = 1, mid, right = cores[0];
        for (int core : cores) {
            right = Math.min(right, core);
        }
        right *= n;

        while (left <= right) {
            mid = left + (right - left) / 2;
            int workEndCount = cores.length;
            for (int core : cores) {
                workEndCount += mid / core;
            }
            if (workEndCount >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getLastWorkCoreIndex(int n, int[] cores, int workEndTime) {
        int workCountBeforeEnd = cores.length;
        for (int core : cores) {
            workCountBeforeEnd += (workEndTime - 1) / core;
        }

        int remainingWorkCount = n - workCountBeforeEnd;
        for (int i = 0; i < cores.length; i++) {
            if (workEndTime % cores[i] == 0) {
                remainingWorkCount -= 1;
                if (remainingWorkCount == 0) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}