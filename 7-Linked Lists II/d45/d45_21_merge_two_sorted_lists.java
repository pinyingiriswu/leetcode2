public class d45_21_merge_two_sorted_lists {
    /** Time: O(m + n)
     * Space: O(1) */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        if (p1 != null) {
            cur.next = p1;
        }

        if (p2 != null) {
            cur.next = p2;
        }

        return dummy.next;
    }
}
