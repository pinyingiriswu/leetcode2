public class d48_61_rotate_list {
    /** Time: O(n)
     * Space: O(1) */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        int len = getLength(head);
        k = k % len;

        if (k == 0) return head;

        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode newHead = p1.next;
        p1.next = null;
        p2.next = dummy.next;
        dummy.next = newHead;

        return dummy.next;
    }

    private int getLength(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
