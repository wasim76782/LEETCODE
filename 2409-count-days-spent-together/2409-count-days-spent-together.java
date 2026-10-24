class Solution {
    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String start = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        if (start.compareTo(end) > 0) return 0;

        return toDay(end) - toDay(start) + 1;
    }

    private int toDay(String date) {
        int m = Integer.parseInt(date.substring(0, 2));
        int d = Integer.parseInt(date.substring(3, 5));
        int sum = d;
        for (int i = 0; i < m - 1; i++) {
            sum += DAYS[i];
        }
        return sum;
    }
}