class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int NEG = -1_000_000_000;

        int[][] prev = new int[n][k + 1];

        for (int j = 0; j < n; j++) {
            Arrays.fill(prev[j], NEG);
        }

        for (int i = 0; i < m; i++) {
            int[][] curr = new int[n][k + 1];

            for (int j = 0; j < n; j++) {
                Arrays.fill(curr[j], NEG);

                int val = grid[i][j];
                int addCost = (val == 0) ? 0 : 1;

                for (int cost = addCost; cost <= k; cost++) {
                    int best = NEG;

                    if (i == 0 && j == 0) {
                        if (cost == addCost) {
                            best = val;
                        }
                    } else {
                        if (i > 0 && prev[j][cost - addCost] != NEG) {
                            best = Math.max(best,
                                    prev[j][cost - addCost] + val);
                        }

                        if (j > 0 && curr[j - 1][cost - addCost] != NEG) {
                            best = Math.max(best,
                                    curr[j - 1][cost - addCost] + val);
                        }
                    }

                    curr[j][cost] = best;
                }
            }

            prev = curr;
        }

        int ans = -1;

        for (int cost = 0; cost <= k; cost++) {
            ans = Math.max(ans, prev[n - 1][cost]);
        }

        return ans < 0 ? -1 : ans;
    }
}