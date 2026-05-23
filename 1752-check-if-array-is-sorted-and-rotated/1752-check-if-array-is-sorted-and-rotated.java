class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int breaks = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int next = nums[(i + 1) % n];
            if (curr > next) {
                breaks++;
                if (breaks > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}