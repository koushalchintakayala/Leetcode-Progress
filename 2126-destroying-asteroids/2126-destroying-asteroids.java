class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currMass = mass;

        for (int val : asteroids) {
            if (currMass < val) {
                return false;
            }

            currMass += val;
        }

        return true;
    }
}