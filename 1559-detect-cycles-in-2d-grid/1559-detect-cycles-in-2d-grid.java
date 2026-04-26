class Solution {

    int rows, cols;
    boolean[][] seen;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public boolean containsCycle(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        seen = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (!seen[i][j]) {
                    if (dfs(grid, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }

            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, int x, int y,
                        int px, int py, char val) {

        seen[x][y] = true;

        for (int k = 0; k < 4; k++) {

            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) {
                continue;
            }

            if (grid[nx][ny] != val) {
                continue;
            }

            // don't go back to immediate previous cell
            if (nx == px && ny == py) {
                continue;
            }

            if (seen[nx][ny]) {
                return true; // found cycle
            }

            if (dfs(grid, nx, ny, x, y, val)) {
                return true;
            }
        }

        return false;
    }
}