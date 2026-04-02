class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][] dp = new int[n][3];

        for(int j = 0; j < n; j++) {
            for(int k = 0; k < 3; k++) {
                dp[j][k] = Integer.MIN_VALUE;
            }
        }

        for(int k = 0; k < 3; k++) {
            if (coins[0][0] >= 0) {
                dp[0][k] = coins[0][0];
            } else {
                if(k > 0) dp[0][k] = 0;
                else dp[0][k] = coins[0][0];
            }
        }

        for(int i = 0; i < m; i++) {
            int[][] curr = new int[n][3];

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 3; k++) {
                    curr[j][k] = Integer.MIN_VALUE;
                }
            }

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 3; k++) {

                    if(i == 0 && j == 0) {
                        curr[j][k] = dp[j][k];
                        continue;
                    }

                    int val = coins[i][j];

                    if(dp[j][k] != Integer.MIN_VALUE) {

                        int temp = dp[j][k] + val;
                        curr[j][k] = Math.max(curr[j][k], temp);

                        if(val < 0 && k < 2) {
                            curr[j][k + 1] = Math.max(curr[j][k + 1], dp[j][k]);
                        }
                    }

                    if(j > 0 && curr[j - 1][k] != Integer.MIN_VALUE) {

                        int temp = curr[j - 1][k] + val;
                        curr[j][k] = Math.max(curr[j][k], temp);

                        if(val < 0 && k < 2) {
                            curr[j][k + 1] = Math.max(curr[j][k + 1], curr[j - 1][k]);
                        }
                    }
                }
            }
            
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 3; k++) {
                    dp[j][k] = curr[j][k];
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for(int k = 0; k < 3; k++) {
            res = Math.max(res, dp[n - 1][k]);
        }

        return res;
    }
}