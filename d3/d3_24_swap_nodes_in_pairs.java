public class d3_24_swap_nodes_in_pairs {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode next = cur.next;
        cur.next = head;
        head.next = swapPairs(next);

        return cur;
    }
}
