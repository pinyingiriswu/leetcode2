public class d2_19_remove_nth_node_from_the_end_of_the_list {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 0; i < n; i++) {
            if (head == null) { return head; }
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return dummy.next;
    }
}
