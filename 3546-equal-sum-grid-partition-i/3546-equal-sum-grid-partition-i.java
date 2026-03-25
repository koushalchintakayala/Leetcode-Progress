class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        long total = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                total += grid[i][j];
            }
        }

        long runningSum = 0;

        for(int i = 0; i < rows - 1; i++) {
            for(int j = 0; j < cols; j++) {
                runningSum += grid[i][j];
            }

            if(runningSum * 2 == total) {
                return true;
            }
        }

        runningSum = 0;

        for(int j = 0; j < cols - 1; j++) {
            for(int i = 0; i < rows; i++) {
                runningSum += grid[i][j];
            }

            if(runningSum * 2 == total) {
                return true;
            }
        }
        return false;
    }
}