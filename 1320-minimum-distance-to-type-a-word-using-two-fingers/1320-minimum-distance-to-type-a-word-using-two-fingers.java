class Solution {
    public int minimumDistance(String word) {
        int n = word.length();

        int[] dp = new int[26];

        int total = 0;

        for(int i = 0; i < n - 1; i++) {
            int curr = word.charAt(i) - 'A';
            int next = word.charAt(i + 1) - 'A';

            int moveCost = getDist(curr, next);
            total += moveCost;

            int[] temp = dp.clone();

            for(int j = 0; j < 26; j++) {
                temp[j] = Math.max(temp[j], dp[j]);

                int saved = moveCost - getDist(j, next);
                temp[curr] = Math.max(temp[curr], dp[j] + saved);
            }
            dp = temp;
        }
        int maxSaved = 0;
        for(int val : dp) {
            maxSaved = Math.max(maxSaved, val);
        }
        return total - maxSaved;
    }
    private int getDist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;

        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);

        return dx + dy;
    }
}