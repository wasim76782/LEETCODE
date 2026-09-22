class Solution {
    public int findNonMinOrMax(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        for (int num : nums) {
            if (num != min && num != max) {
                return num;
            }
        }

        return -1;
    }
}