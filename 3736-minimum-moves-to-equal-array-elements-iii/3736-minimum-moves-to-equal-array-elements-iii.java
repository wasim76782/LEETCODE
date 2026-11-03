class Solution {
    public int minMoves(int[] nums) {
        int count = 0;
        int ans = 0;
        int max = nums[0];

        for (int num : nums) {
            if (max < num) {
                ans += (num - max) * count;
                max = num;
            } else if (num < max) {
                ans += max - num;
            }
            count++;
        }

        return ans;
    }
}