class SparseTable {
    int n;
    int maxLog;
    int[][] mx;
    int[][] mn;
    int[] lg;

    SparseTable(int[] nums) {
        n = nums.length;
        maxLog = 32 - Integer.numberOfLeadingZeros(n) + 1;

        mx = new int[n][maxLog];
        mn = new int[n][maxLog];
        lg = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i >> 1] + 1;
        }

        for (int i = 0; i < n; i++) {
            mx[i][0] = nums[i];
            mn[i][0] = nums[i];
        }

        for (int j = 1; j < maxLog; j++) {
            int len = 1 << j;

            for (int i = 0; i + len <= n; i++) {
                mx[i][j] = Math.max(
                    mx[i][j - 1],
                    mx[i + (len >> 1)][j - 1]
                );

                mn[i][j] = Math.min(
                    mn[i][j - 1],
                    mn[i + (len >> 1)][j - 1]
                );
            }
        }
    }

    int getMax(int l, int r) {
        int k = lg[r - l + 1];
        return Math.max(
            mx[l][k],
            mx[r - (1 << k) + 1][k]
        );
    }

    int getMin(int l, int r) {
        int k = lg[r - l + 1];
        return Math.min(
            mn[l][k],
            mn[r - (1 << k) + 1][k]
        );
    }
}
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        SparseTable st = new SparseTable(nums);

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        for (int l = 0; l < n; l++) {
            long val = (long) st.getMax(l, n - 1)
                     - (long) st.getMin(l, n - 1);

            pq.offer(new long[] {val, l, n - 1});
        }

        long ans = 0;

        while (k-- > 0) {
            long[] curr = pq.poll();

            long val = curr[0];
            int l = (int) curr[1];
            int r = (int) curr[2];

            ans += val;

            if (r > l) {
                long nextVal = (long) st.getMax(l, r - 1)
                             - (long) st.getMin(l, r - 1);

                pq.offer(new long[] {nextVal, l, r - 1});
            }
        }
        return ans;
    }
}