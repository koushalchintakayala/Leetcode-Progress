class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countBounded(nums, right) - countBounded(nums, left - 1);
    }

    private int countBounded(int[] nums, int bound) {
        int count = 0, cur = 0;
        for (int num : nums) {
            if (num <= bound) {
                cur++;
                count += cur;
            } else {
                cur = 0;
            }
        }
        return count;
    }
}