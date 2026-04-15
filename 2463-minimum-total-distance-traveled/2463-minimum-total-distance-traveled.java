class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        long[][] dp = new long[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], (long)1e18);
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int j = 1; j <= m; j++) {
            int pos = factory[j - 1][0];
            int limit = factory[j - 1][1];

            for (int i = 0; i <= n; i++) {
                dp[i][j] = dp[i][j - 1];

                long cost = 0;
                for (int k = 1; k <= limit && k <= i; k++) {
                    int robotIndex = i - k;

                    cost += Math.abs(robot.get(robotIndex) - pos);

                    long prev = dp[i - k][j - 1];
                    long curr = prev + cost;

                    if (curr < dp[i][j]) {
                        dp[i][j] = curr;
                    }
                }
            }
        }

        return dp[n][m];
    }
}