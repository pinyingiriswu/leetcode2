public class d6_25_reverse_nodes_in_k_group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int count = 1;
        while (tail != null && count < k) {
            tail = tail.next;
            count++;
        }
        if (tail == null) {
            return head;
        }

        ListNode next = reverseKGroup(tail.next, k);
        tail.next = null;
        ListNode revHead = reverse(head);
        head.next = next;
        return revHead;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
