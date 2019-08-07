public class d44_143_reorder_list {
    /** Time: O(n)
     * Space: O(1) */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode m = findMid(head);
        ListNode n = reverse(m.next);
        m.next = null; // break from middle
        ListNode dummy = new ListNode(-1);
        int index = 0;

        // merge the two linked lists
        while (head != null && n != null) {
            if (index % 2 == 0) {
                dummy.next = head;
                head = head.next;
            }
            if (index % 2 == 1) {
                dummy.next = n;
                n = n.next;
            }
            dummy = dummy.next;
            index++;
        }
        if (head != null) {
            dummy.next = head;
        }
        if (n != null) {
            dummy.next = n;
        }
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
