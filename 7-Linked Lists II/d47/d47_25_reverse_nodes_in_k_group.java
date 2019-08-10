public class d47_25_reverse_nodes_in_k_group {
    /** Time: O(n)
     * Space: O(1) */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = head;
        int count = 0;

        while (p2 != null) {
            count++;
            if (count == k) {
                p1 = reverseList(p1, p2);
                p2 = p1;
                count = 0;
            }
            p2 = p2.next;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode start, ListNode end) {
        ListNode prev = end.next;
        ListNode head = start.next;
        ListNode cur = head;

        while (prev != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        start.next = prev;
        return head;
    }
}
