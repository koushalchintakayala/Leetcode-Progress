class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) {

            int size = list.size();

            long[] prefix = new long[size];
            prefix[0] = list.get(0);

            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for (int i = 0; i < size; i++) {

                int currIndex = list.get(i);

                long leftSum = 0;
                if (i > 0) {
                    long leftTotal = prefix[i - 1];
                    leftSum = (long) i * currIndex - leftTotal;
                }

                long rightSum = 0;
                if (i < size - 1) {
                    long rightTotal = prefix[size - 1] - prefix[i];
                    rightSum = rightTotal - (long) (size - i - 1) * currIndex;
                }

                res[currIndex] = leftSum + rightSum;
            }
        }
        return res;
    }
}