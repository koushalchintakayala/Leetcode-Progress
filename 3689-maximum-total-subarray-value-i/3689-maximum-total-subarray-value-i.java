class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int minVal = nums[0];
        int maxVal = nums[0];

        for (int val : nums) {
            if (val < minVal) {
                minVal = val;
            }

            if (val > maxVal) {
                maxVal = val;
            }
        }

        long best = (long) maxVal - minVal;
        return best * k;
    }
}