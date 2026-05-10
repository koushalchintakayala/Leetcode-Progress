class Solution {
    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {

                long diff = (long) nums[j] - nums[i];

                if (diff >= -target && diff <= target) {

                    int next = dp[i] + 1;

                    if (next > dp[j]) {
                        dp[j] = next;
                    }
                }
            }
        }
        return dp[n - 1];
    }
}