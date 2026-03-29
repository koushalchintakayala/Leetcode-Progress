class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char a1 = s1.charAt(0);
        char a2 = s1.charAt(2);

        char b1 = s2.charAt(0);
        char b2 = s2.charAt(2);

        char c1 = s1.charAt(1);
        char c2 = s1.charAt(3);

        char d1 = s2.charAt(1);
        char d2 = s2.charAt(3);

        boolean evenMatch = (a1 == b1 && a2 == b2) || (a1 == b2 && a2 == b1);

        boolean oddMatch = (c1 == d1 && c2 == d2) || (c1 == d2 && c2 == d1);

        return evenMatch && oddMatch;
    }
}