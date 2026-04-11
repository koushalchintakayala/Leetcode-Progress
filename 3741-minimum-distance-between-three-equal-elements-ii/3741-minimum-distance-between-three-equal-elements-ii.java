class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (int val : map.keySet()) {
            List<Integer> list = map.get(val);

            if (list.size() < 3) continue;

            for(int i = 0; i + 2 < list.size(); i++) {
                int first = list.get(i);
                int last = list.get(i + 2);

                int dist = 2 * (last - first);
                ans = Math.min(ans, dist);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}