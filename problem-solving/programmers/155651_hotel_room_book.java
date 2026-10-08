// https://school.programmers.co.kr/learn/courses/30/lessons/155651

class Solution {
    public int solution(String[][] bookTimes) {
        int[] books = new int[60 * 24 + 10];

        for (String[] bookTime : bookTimes) {
            int checkin = timeToMinutes(bookTime[0]);
            int checkout = timeToMinutes(bookTime[1]) + 10;

            ++books[checkin];
            --books[checkout];
        }

        int answer = 0;
        int roomCount = 0;

        for (int book : books) {
            if (book != 0) {
                roomCount += book;
                answer = Math.max(answer, roomCount);
            }
        }

        return answer;
    }

    private int timeToMinutes(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60
                + Integer.parseInt(time.substring(3, 5));
    }
}