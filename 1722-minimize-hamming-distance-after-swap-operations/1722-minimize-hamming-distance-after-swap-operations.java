class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int n = source.length;

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] swap : allowedSwaps) {
            int u = swap[0];
            int v = swap[1];

            int pu = find(parent, u);
            int pv = find(parent, v);

            if(pu != pv) {
                parent[pu] = pv;
            }
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int root = find(parent, i);

            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int mismatch = 0;

        for(List<Integer> list : groups.values()) {

            Map<Integer, Integer> freq = new HashMap<>();

            for(int idx : list) {
                int val = source[idx];
                freq.put(val, freq.getOrDefault(val, 0) + 1);
            }

            for(int idx : list) {
                int val = target[idx];

                if(freq.containsKey(val) && freq.get(val) > 0) {
                    freq.put(val, freq.get(val) - 1);
                } else {
                    mismatch++;
                }
            }
        }

        return mismatch;
    }

    private int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}