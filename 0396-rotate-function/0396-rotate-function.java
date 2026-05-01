class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        long sum = 0;
        long curr = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            curr += (long)i * nums[i];
        }

        long maxVal = curr;
        for (int k = 1; k < n; k++) {
            int moved = nums[n - k];

            long next = curr + sum - (long)n * moved;

            curr = next;

            if (curr > maxVal) {
                maxVal = curr;
            }
        }

        return (int)maxVal;
    }
}