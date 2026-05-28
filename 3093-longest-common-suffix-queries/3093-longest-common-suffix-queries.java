class Solution {
    class Node {
        Node[] next = new Node[26];
        int idx = -1;
        int len = Integer.MAX_VALUE;
    }
    private void update(Node node, int wordLen, int index) {
        if (wordLen < node.len) {
            node.len = wordLen;
            node.idx = index;
        } else if (wordLen == node.len && index < node.idx) {
            node.idx = index;
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Node root = new Node();
        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            int n = word.length();
            Node curr = root;
            update(curr, n, i);
            for (int j = n - 1; j >= 0; j--) {
                int ch = word.charAt(j) - 'a';
                if (curr.next[ch] == null) {
                    curr.next[ch] = new Node();
                }
                curr = curr.next[ch];
                update(curr, n, i);
            }
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            Node curr = root;
            for (int j = query.length() - 1; j >= 0; j--) {
                int ch = query.charAt(j) - 'a';
                if (curr.next[ch] == null) {
                    break;
                }
                curr = curr.next[ch];
            }
            ans[i] = curr.idx;
        }
        return ans;
    }
}