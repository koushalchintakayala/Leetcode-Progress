class Solution {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int val : nums) {
            int sum = 0;
            int curr = val;
            while (curr > 0) {
                sum += curr % 10;
                curr /= 10;
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}