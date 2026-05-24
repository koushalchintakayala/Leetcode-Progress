class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(i, arr, d, dp));
        }
        return ans;
    }
    private int solve(int idx, int[] arr, int d, int[] dp) {
        if (dp[idx] != 0) {
            return dp[idx];
        }
        int best = 1;
        for (int j = idx - 1; j >= Math.max(0, idx - d); j--) {
            if (arr[j] >= arr[idx]) {
                break;
            }
            int next = 1 + solve(j, arr, d, dp);
            best = Math.max(best, next);
        }
        for (int j = idx + 1; j <= Math.min(arr.length - 1, idx + d); j++) {

            if (arr[j] >= arr[idx]) {
                break;
            }
            int next = 1 + solve(j, arr, d, dp);
            best = Math.max(best, next);
        }
        dp[idx] = best;
        return best;
    }
}