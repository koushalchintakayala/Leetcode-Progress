class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union(i, j, parent);
                }
            }
        }

        char[] res = new char[n];
        Arrays.fill(res, '#');

        char curr = 'a';

        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i, parent);

            if (!map.containsKey(root)) {
                if (curr > 'z') return "";
                map.put(root, curr);
                curr++;
            }

            res[i] = map.get(root);
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (res[i] == res[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(res);
    }

    private int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }

    private void union(int a, int b, int[] parent) {
        int pa = find(a, parent);
        int pb = find(b, parent);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}