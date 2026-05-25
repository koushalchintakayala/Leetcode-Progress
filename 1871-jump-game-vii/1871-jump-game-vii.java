class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] reach = new boolean[n];
        reach[0] = true;
        int usable = 0;
        for (int i = 1; i < n; i++) {
            int left = i - maxJump;
            int right = i - minJump;
            if (right >= 0 && reach[right]) {
                usable++;
            }
            if (left - 1 >= 0 && reach[left - 1]) {
                usable--;
            }
            if (s.charAt(i) == '0' && usable > 0) {
                reach[i] = true;
            }
        }
        return reach[n - 1];
    }
}