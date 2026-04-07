class Robot {

    int width, height;
    int x, y;
    int dir;

    int[][] move = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    String[] dirName = {"East", "North", "West", "South"};

    int cycle;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;

        x = 0;
        y = 0;
        dir = 0;

        cycle = 2 * (width + height - 2);
    }
    
    public void step(int num) {
        num = num % cycle;

        if(num == 0) num = cycle;

        while (num > 0) {
            int nx = x + move[dir][0];
            int ny = y + move[dir][1];

            if(nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4;
                continue;
            }

            x = nx;
            y = ny;
            num--;
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dirName[dir];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */