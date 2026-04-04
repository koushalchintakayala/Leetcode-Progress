class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();

        if(rows == 1) return encodedText;

        int cols = n / rows;
        StringBuilder ans = new StringBuilder();

        for(int start = 0; start < cols; start++) {
            int i = 0;
            int j = start;

            while(i < rows && j < cols) {
                int index = i * cols + j;
                char ch = encodedText.charAt(index);

                ans.append(ch);
                i++;
                j++;
            }
        } 
        int end = ans.length() - 1;

        while(end >= 0 && ans.charAt(end) == ' ') {
            end--;
        }

        return ans.substring(0, end + 1);
    }
}