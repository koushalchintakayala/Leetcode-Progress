class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        if(x % 10 == 0 & x != 0) return false;

        int reversedHalf = 0;

        while (x > reversedHalf) {
            int lastDigit = x % 10;
            reversedHalf = reversedHalf * 10 + lastDigit;
            x = x / 10;
        }
        return (x == reversedHalf) || (x == reversedHalf / 10);
    }
}