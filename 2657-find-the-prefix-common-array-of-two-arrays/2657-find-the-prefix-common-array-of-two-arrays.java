class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] ans = new int[n];
        int[] freq = new int[n + 1];

        int common = 0;

        for (int i = 0; i < n; i++) {

            int val1 = A[i];
            freq[val1]++;

            if (freq[val1] == 2) {
                common++;
            }

            int val2 = B[i];
            freq[val2]++;

            if (freq[val2] == 2) {
                common++;
            }

            ans[i] = common;
        }

        return ans;
    }
}