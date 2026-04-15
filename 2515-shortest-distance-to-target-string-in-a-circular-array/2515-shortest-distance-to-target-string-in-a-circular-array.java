class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(words[i].equals(target)) {
                
                int diff = Math.abs(i - startIndex);
                int curr = Math.min(diff, n - diff);

                if(curr < ans) {
                    ans = curr;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}