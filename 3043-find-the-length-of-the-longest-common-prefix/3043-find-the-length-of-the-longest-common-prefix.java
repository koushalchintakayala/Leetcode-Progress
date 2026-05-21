class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr1) {
            int curr = val;
            while (curr > 0) {
                set.add(curr);
                curr /= 10;
            }
        }
        int ans = 0;
        for (int val : arr2) {
            int curr = val;
            while (curr > 0) {
                if (set.contains(curr)) {
                    int len = String.valueOf(curr).length();

                    if (len > ans) {
                        ans = len;
                    }

                    break;
                }
                curr /= 10;
            }
        }
        return ans;
    }
}