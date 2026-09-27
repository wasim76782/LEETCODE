class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
         for (int i = left; i <= right; i++) {
            int current = i;
            while (current > 0) {
                int digit = current % 10;
                if (digit == 0 || i % digit != 0) {
                    break;
                }
                current /= 10;
            }
            if (current == 0) {
                result.add(i);
            }
        }
        return result;
    }
}