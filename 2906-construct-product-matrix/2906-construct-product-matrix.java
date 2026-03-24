class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int size = n * m;
        int mod = 12345;

        int[] arr = new int[size];

        int idx = 0;
        for(int[] row : grid) {
            for(int val : row) {
                arr[idx++] = val % mod;
            }
        }

        int[] prefix = new int[size];
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % mod;
        }

        int[] suffix = new int[size];
        suffix[size - 1] = 1;
        for(int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1] % mod);
        }

        int[][] res = new int[n][m];
        idx = 0;
        for(int i = 0; i < size; i++) {
            int val = (prefix[i] * suffix[i]) % mod;
            res[idx / m][idx % m] = val;
            idx++;
        }
        return res;
    }
}