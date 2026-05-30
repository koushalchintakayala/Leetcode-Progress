class Solution {
    class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[n * 4];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) >> 1;

            if (idx <= mid) {
                update(node * 2, l, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, val);
            }

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int left, int right) {
            return query(1, 0, n - 1, left, right);
        }

        private int query(int node, int l, int r, int left, int right) {
            if (left > r || right < l) {
                return 0;
            }

            if (left <= l && r <= right) {
                return tree[node];
            }

            int mid = (l + r) >> 1;

            return Math.max(
                query(node * 2, l, mid, left, right),
                query(node * 2 + 1, mid + 1, r, left, right)
            );
        }
    }
    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;

        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
        }
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(maxX + 1);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }
        SegmentTree seg = new SegmentTree(maxX + 2);

        Integer prev = null;
        for (int curr : obstacles) {
            if (prev != null) {
                seg.update(curr, curr - prev);
            }
            prev = curr;
        }
        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];

                int p = obstacles.floor(x);
                int best = seg.query(0, p);
                best = Math.max(best, x - p);
                ans.add(best >= sz);
            } else {
                int pos = q[1];

                int left = obstacles.lower(pos);
                int right = obstacles.higher(pos);

                seg.update(pos, 0);
                seg.update(right, right - left);

                obstacles.remove(pos);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}