// https://school.programmers.co.kr/learn/courses/30/lessons/468371

class Solution {
    public int solution(int[][] signals) {
        int lcmCycle = 1;

        for (int[] signal : signals) {
            int cycle = getCycle(signal);
            lcmCycle = lcm(lcmCycle, cycle);
        }

        for (int t = 1; t <= lcmCycle; t++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                allYellow = allYellow && isYellow(signal, t);
            }

            if (allYellow) {
                return t;
            }
        }

        return -1;
    }

    private boolean isYellow(int[] signal, int t) {
        int cycleTime = (t - 1) % getCycle(signal) + 1;

        return signal[0] < cycleTime
                && cycleTime <= signal[0] + signal[1];
    }

    private int getCycle(int[] signal) {
        return signal[0] + signal[1] + signal[2];
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}