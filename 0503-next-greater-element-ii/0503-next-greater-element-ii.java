class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * n; i++) {
            int curr = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < curr) {
                res[stack.pop()] = curr;
            }

            if (i < n) {
                stack.push(i);
            }
        }
        return res;
        
    }
}