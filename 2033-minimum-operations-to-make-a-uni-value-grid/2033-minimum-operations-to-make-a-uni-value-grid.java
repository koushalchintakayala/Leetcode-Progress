class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] arr = new int[m * n];
        int idx = 0;

        int rem = grid[0][0] % x;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] % x != rem) {
                    return -1;
                }

                arr[idx++] = grid[i][j];
            }
        }

        Arrays.sort(arr);

        int target = arr[arr.length / 2];

        int ops = 0;

        for (int val : arr) {
            int diff = Math.abs(val - target);
            ops += diff / x;
        }

        return ops;
    }
}