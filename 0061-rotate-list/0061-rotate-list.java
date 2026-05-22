class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len;
        if (k == 0) {
            return head;
        }

        int move = len - k;
        ListNode curr = head;
        ListNode prev = null;
        while (move > 0) {
            prev = curr;
            curr = curr.next;
            move--;
        }
        prev.next = null;
        tail.next = head;

        return curr;
    }
}