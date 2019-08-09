public class d46_82_remove_duplicates_from_sorted_list_ii {
    /** Time: O(n)
     * Space: O(1) */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            if (p2.val == p2.next.val) {
                int dupVal = p2.val;
                while (p2 != null && p2.val == dupVal) {
                    p1.next = p2.next;
                    p2 = p2.next;
                }
            } else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return dummy.next;
    }
}
