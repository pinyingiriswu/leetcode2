public class d44_24_swap_nodes_in_pairs {
    /** Time: O(n)
     * Space: O(1) */

    /** Recursive */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        cur.next = head;
        head.next = swapPairs(next);
        return cur;
    }

    /** Iterative */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null && p.next.next != null) {
            ListNode temp = p.next;
            p.next = p.next.next;
            temp.next = p.next.next;
            p.next.next = temp;
            p = p.next.next;
        }
        return dummy.next;
    }
}
