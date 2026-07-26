class Solution {

    public String gcdOfStrings(String str1, String str2) {

        if (!sameOrder(str1, str2)) {
            return "";
        }

        int len = gcd(str1.length(), str2.length());

        return str1.substring(0, len);
    }

    private boolean sameOrder(String a, String b) {

        int total = a.length() + b.length();

        for (int i = 0; i < total; i++) {

            char first;

            if (i < a.length()) {
                first = a.charAt(i);
            } else {
                first = b.charAt(i - a.length());
            }

            char second;

            if (i < b.length()) {
                second = b.charAt(i);
            } else {
                second = a.charAt(i - b.length());
            }

            if (first != second) {
                return false;
            }
        }

        return true;
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}