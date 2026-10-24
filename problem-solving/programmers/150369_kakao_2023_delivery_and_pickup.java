// https://school.programmers.co.kr/learn/courses/30/lessons/150369

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int deliveryIdx = n - 1;
        int pickupIdx = n - 1;

        while (deliveryIdx >= 0 || pickupIdx >= 0) {
            int maxDistance = 0;

            int boxes = cap;
            while (deliveryIdx >= 0 && boxes > 0) {
                if (deliveries[deliveryIdx] > 0) {
                    int deliveryCount = Math.min(deliveries[deliveryIdx], boxes);
                    deliveries[deliveryIdx] -= deliveryCount;
                    boxes -= deliveryCount;

                    maxDistance = Math.max(maxDistance, deliveryIdx + 1);
                }

                if (deliveries[deliveryIdx] == 0) {
                    --deliveryIdx;
                }
            }

            int pickupCounts = 0;
            while (pickupIdx >= 0 && pickupCounts < cap) {
                if (pickups[pickupIdx] > 0) {
                    int pickupCount = Math.min(pickups[pickupIdx], cap - pickupCounts);
                    pickups[pickupIdx] -= pickupCount;
                    pickupCounts += pickupCount;

                    maxDistance = Math.max(maxDistance, pickupIdx + 1);
                }

                if (pickups[pickupIdx] == 0) {
                    --pickupIdx;
                }
            }

            answer += maxDistance * 2;
        }

        return answer;
    }
}