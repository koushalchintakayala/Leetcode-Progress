class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();

        for(int[] obs : obstacles) {
            long key = ((long) obs[0] << 32) | (obs[1] & 0xffffffffL);
            set.add(key);
        }

        int x = 0, y = 0;
        int dir = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int maxDist = 0;

        for(int cmd : commands)  {
           
            if(cmd == -1) {
                dir = (dir + 1) % 4;
            } else if(cmd == -2) {
                dir = (dir + 3) % 4;
            } else {
                int steps = cmd;

                for(int i = 0; i < steps; i++) {
                    int nextX = x + dx[dir];
                    int nextY = y + dy[dir];

                    long key = ((long) nextX << 32) | (nextY & 0xffffffffL);

                    if(set.contains(key)) {
                        break;
                    }

                    x = nextX;
                    y = nextY;

                    int currDist = x * x + y * y;
                    if(currDist > maxDist) {
                        maxDist = currDist;
                    }
                }
            }
        }
        return maxDist;
    }
}