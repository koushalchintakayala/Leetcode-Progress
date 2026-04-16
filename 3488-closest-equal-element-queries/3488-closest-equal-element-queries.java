class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int val = nums[i];
            map.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < queries.length; i++) {
            int idx = queries[i];
            int val = nums[idx];

            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                res.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);

            int size = list.size();

            int prevIdx = (pos - 1 + size) % size;
            int nextIdx = (pos + 1) % size;

            int prev = list.get(prevIdx);
            int next = list.get(nextIdx);

            int d1 = Math.abs(idx - prev);
            int d2 = Math.abs(idx - next);

            int dist1 = Math.min(d1, n - d1);
            int dist2 = Math.min(d2, n - d2);

            int ans = Math.min(dist1, dist2);

            res.add(ans);
        }

        return res;
    }
}