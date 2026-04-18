class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];

            if (map.containsKey(curr)) {
                int prev = map.get(curr);

                int dist = i - prev;

                if (dist < ans) {
                    ans = dist;
                }
            }

            int rev = getReverse(curr);

            map.put(rev, i);
        } 
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int getReverse(int val) {

        int res = 0;

        while (val > 0) {
            int d = val % 10;
            res = res * 10 + d;
            val = val / 10;
        }
        return res;
    }
}