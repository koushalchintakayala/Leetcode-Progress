class Solution {

    int[][][] dirs = {
            {},
            {{0,-1},{0,1}},       //1
            {{-1,0},{1,0}},       //2
            {{0,-1},{1,0}},       //3
            {{0,1},{1,0}},        //4
            {{0,-1},{-1,0}},      //5
            {{0,1},{-1,0}}        //6
    };

    public boolean hasValidPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        return dfs(0, 0, grid, vis, m, n);
    }

    private boolean dfs(int r, int c, int[][] grid, boolean[][] vis, int m, int n) {

        if (r == m - 1 && c == n - 1) {
            return true;
        }

        vis[r][c] = true;

        for (int[] move : dirs[grid[r][c]]) {

            int nr = r + move[0];
            int nc = c + move[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc]) {
                continue;
            }

            if (!isConnected(r, c, nr, nc, grid)) {
                continue;
            }

            if (dfs(nr, nc, grid, vis, m, n)) {
                return true;
            }
        }

        return false;
    }

    private boolean isConnected(int r, int c, int nr, int nc, int[][] grid) {

        for (int[] back : dirs[grid[nr][nc]]) {

            if (nr + back[0] == r && nc + back[1] == c) {
                return true;
            }
        }

        return false;
    }
}