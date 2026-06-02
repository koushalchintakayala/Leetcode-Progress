class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {

                int waterFinish = waterStartTime[j] + waterDuration[j];

                int landThenWater =
                        Math.max(waterStartTime[j], landFinish) + waterDuration[j];

                int waterThenLand =
                        Math.max(landStartTime[i], waterFinish) + landDuration[i];

                ans = Math.min(ans, Math.min(landThenWater, waterThenLand));
            }
        }
        return ans;
    }
}