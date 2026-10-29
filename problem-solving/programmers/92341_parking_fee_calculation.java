// https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] parkingMin = new int[10000];
        int[] inMin = new int[10000];
        Arrays.fill(inMin, -1);

        TreeSet<Integer> carSet = new TreeSet<>();

        for (String record : records) {
            String[] parkingInfos = record.split(" ");

            String time = parkingInfos[0];
            int no = Integer.parseInt(parkingInfos[1]);
            String inOut = parkingInfos[2];

            if (inOut.equals("IN")) {
                inMin[no] = timeToMin(time);
                carSet.add(no);
            } else if (inOut.equals("OUT")) {
                parkingMin[no] += timeToMin(time) - inMin[no];
                inMin[no] = -1;
            }
        }

        int[] answer = new int[carSet.size()];
        int i = 0;
        int maxFeeMin = timeToMin("23:59");

        for (Integer no : carSet) {
            if (inMin[no] > -1) {
                parkingMin[no] += maxFeeMin - inMin[no];
            }
            answer[i++] = calculateFee(fees, parkingMin[no]);
        }

        return answer;
    }

    private int timeToMin(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60
                + Integer.parseInt(time.substring(3, 5));
    }

    private int calculateFee(int[] fees, int parkingMin) {
        int fee = fees[1];

        if (parkingMin > fees[0]) {
            fee += (parkingMin - fees[0] + fees[2] - 1) / fees[2] * fees[3];
        }

        return fee;
    }
}