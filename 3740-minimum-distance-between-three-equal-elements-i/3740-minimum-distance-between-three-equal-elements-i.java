class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int val = nums[i];
            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(i);
        }
        int ans = Integer.MAX_VALUE;

        for( int key: map.keySet()) {
            List<Integer> list = map.get(key);

            int size = list.size();
            if(size < 3) continue;

            for(int i = 0; i < size - 2; i++) {
                int first = list.get(i);

                for(int j = i + 2; j < size; j++) {
                    int last = list.get(j);

                    int dist = 2 * (last - first);
                    ans = Math.min(ans, dist);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}