class Solution {

    public String reverseWords(String s) {

        char[] arr = s.toCharArray();

        int len = cleanSpaces(arr);

        reverse(arr, 0, len - 1);

        int start = 0;

        for (int end = 0; end <= len; end++) {

            if (end == len || arr[end] == ' ') {

                reverse(arr, start, end - 1);

                start = end + 1;
            }
        }

        return new String(arr, 0, len);
    }

    private int cleanSpaces(char[] arr) {

        int i = 0;
        int j = 0;

        while (j < arr.length) {

            while (j < arr.length && arr[j] == ' ') {
                j++;
            }

            while (j < arr.length && arr[j] != ' ') {
                arr[i++] = arr[j++];
            }

            while (j < arr.length && arr[j] == ' ') {
                j++;
            }

            if (j < arr.length) {
                arr[i++] = ' ';
            }
        }

        return i;
    }

    private void reverse(char[] arr, int left, int right) {

        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}