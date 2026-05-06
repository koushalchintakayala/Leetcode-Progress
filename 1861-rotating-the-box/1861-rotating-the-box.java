class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {

        int rows = boxGrid.length;
        int cols = boxGrid[0].length;

        for (int i = 0; i < rows; i++) {

            int empty = cols - 1;

            for (int j = cols - 1; j >= 0; j--) {

                if (boxGrid[i][j] == '*') {
                    empty = j - 1;
                }

                else if (boxGrid[i][j] == '#') {

                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';

                    empty--;
                }
            }
        }

        char[][] ans = new char[cols][rows];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                ans[j][rows - 1 - i] = boxGrid[i][j];
            }
        }

        return ans;
    }
}