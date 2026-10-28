// https://school.programmers.co.kr/learn/courses/30/lessons/150368

class Solution {
    private final int[] answer = {0,0};
    private final int[] discountPers = {10,20,30,40};
    private final int[] emoticonDiscounts = new int[8];

    public int[] solution(int[][] users, int[] emoticons) {
        find(users, emoticons, 0);

        return answer;
    }

    private void find(int[][] users, int[] emoticons, int emoticonIdx) {
        if (emoticonIdx == emoticons.length) {
            int[] result = {0,0};

            for (int[] user : users) {
                int pay = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (emoticonDiscounts[i] >= user[0]) {
                        pay += emoticons[i] * (100 - emoticonDiscounts[i]) / 100;
                    }
                }

                if (pay >= user[1]) {
                    result[0] += 1;
                } else {
                    result[1] += pay;
                }
            }

            if (answer[0] < result[0]) {
                answer[0] = result[0];
                answer[1] = result[1];
            } else if (answer[0] == result[0] && answer[1] < result[1]) {
                answer[1] = result[1];
            }

            return;
        }

        for (int discountPer : discountPers) {
            emoticonDiscounts[emoticonIdx] = discountPer;
            find(users, emoticons, emoticonIdx + 1);
        }
    }
}