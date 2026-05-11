class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : nums) {
            String curr = String.valueOf(val);
            for (int i = 0; i < curr.length(); i++) {
                list.add(curr.charAt(i) - '0');
            }
        }
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}