public class d43_19_remove_nth_node_from_end_of_list {
    /** Time: O(L)
     * Space: O(1) */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        // make sure p1 and p2 are 2 nodes (in between apart)
        while (p1 != null && n >= 0) {
            p1 = p1.next;
            n--;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return dummy.next;
    }
}
