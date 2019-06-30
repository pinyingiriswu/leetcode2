public class d6_25_reverse_nodes_in_k_group {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2 = head;
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
