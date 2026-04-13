class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                int currDist = Math.abs(i - start);

                if(currDist < minDist) {
                    minDist = currDist;
                }
            }
        }
        return minDist;
    }
}