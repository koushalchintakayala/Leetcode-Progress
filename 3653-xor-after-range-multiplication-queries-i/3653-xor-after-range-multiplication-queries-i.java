class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;

        for(int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            for(int idx = l; idx <= r; idx += k) {
                long temp = nums[idx];
                temp = temp * v;
                temp %= mod;

                nums[idx] = (int) temp;
            }
        }
        int res = 0;
        for(int val : nums) {
            res ^= val;
        }
        return res;
    }
}