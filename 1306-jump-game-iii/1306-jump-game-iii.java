class Solution {

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int curr, boolean[] visited) {
        if (curr < 0 || curr >= arr.length) {
            return false;
        }
        if (visited[curr]) {
            return false;
        }
        if (arr[curr] == 0) {
            return true;
        }
        visited[curr] = true;
        int jump = arr[curr];
        int forward = curr + jump;
        int backward = curr - jump;

        if (dfs(arr, forward, visited)) {
            return true;
        }
        return dfs(arr, backward, visited);
    }
}