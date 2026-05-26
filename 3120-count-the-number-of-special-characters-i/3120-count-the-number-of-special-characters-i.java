class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] small = new boolean[26];
        boolean[] capital = new boolean[26];

        for (char ch : word.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                small[idx] = true;
            } else {
                int idx = ch - 'A';
                capital[idx] = true;
            }
        }
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (small[i] && capital[i]) {
                count++;
            }
        }
        return count;
    }
}