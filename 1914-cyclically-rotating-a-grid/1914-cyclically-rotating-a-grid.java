class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        int layers = Math.min(rows, cols) / 2;

        for (int layer = 0; layer < layers; layer++) {

            ArrayList<Integer> vals = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = rows - layer - 1;
            int right = cols - layer - 1;

            for (int j = left; j <= right; j++) {
                vals.add(grid[top][j]);
            }

            for (int i = top + 1; i <= bottom - 1; i++) {
                vals.add(grid[i][right]);
            }

            for (int j = right; j >= left; j--) {
                vals.add(grid[bottom][j]);
            }

            for (int i = bottom - 1; i >= top + 1; i--) {
                vals.add(grid[i][left]);
            }

            int size = vals.size();
            int rotate = k % size;

            ArrayList<Integer> rotated = new ArrayList<>(Collections.nCopies(size, 0));

            for (int i = 0; i < size; i++) {

                int next = i - rotate;

                if (next < 0) {
                    next += size;
                }

                rotated.set(next, vals.get(i));
            }

            int idx = 0;

            for (int j = left; j <= right; j++) {
                grid[top][j] = rotated.get(idx++);
            }

            for (int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right] = rotated.get(idx++);
            }

            for (int j = right; j >= left; j--) {
                grid[bottom][j] = rotated.get(idx++);
            }

            for (int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left] = rotated.get(idx++);
            }
        }

        return grid;
    }
}