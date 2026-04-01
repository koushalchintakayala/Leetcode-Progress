class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        int[][] arr = new int[n][4];
        for(int i = 0; i < n; i++) {
            arr[i][0] = positions[i];
            arr[i][1] = healths[i];
            arr[i][2] = directions.charAt(i);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            int currDir = arr[i][2];

            if(currDir == 'R') {
                st.push(i);
            } else {
                while(!st.isEmpty() && arr[i][1] > 0) {
                    int top = st.peek();

                    if(arr[top][2] == 'L') break;

                    if(arr[top][1] > arr[i][1]) {
                        arr[top][1] -= 1;
                        arr[i][1] = 0;
                        break;
                    } else if(arr[top][1] < arr[i][1]) {
                        arr[i][1] -= 1;
                        arr[top][1] = 0;
                        st.pop();
                    } else {
                        arr[i][1] = 0;
                        arr[top][1] = 0;
                        st.pop();
                        break;
                    }
                }
            }
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i = 0; i < n; i++) {
            if(arr[i][1] > 0) {
                int idx = arr[i][3];
                res[idx] = arr[i][1];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(res[i] != -1) {
                ans.add(res[i]);
            }
        }
        return ans;
    }
}