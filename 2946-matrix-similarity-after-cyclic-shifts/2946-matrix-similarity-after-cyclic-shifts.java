class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k % n;

        for (int i = 0; i < m; i++) {
            int[] originalRow = mat[i];

            for (int j = 0; j < n; j++) {
                int newIndex;

                if (i % 2 == 0) {
                    newIndex = (j + k) % n;
                } 
                else {
                    newIndex = (j - k % n + n) % n;
                }

                if (originalRow[j] != originalRow[newIndex]) {
                    return false;
                }
            }
        }

        return true;
    }
}