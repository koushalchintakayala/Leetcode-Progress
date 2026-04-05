class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;

        for(int i = 0; i < moves.length(); i++) {
            char curr = moves.charAt(i);
            
            if(curr == 'U') {
                vertical++;
            } else if(curr == 'D') {
                vertical--;
            } else if(curr == 'R') {
                horizontal++;
            } else {
                horizontal--;
            }
        }

        if(vertical == 0 && horizontal == 0) {
            return true;
        }
        return false;
    }
}