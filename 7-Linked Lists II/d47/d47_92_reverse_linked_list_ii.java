public class d47_92_reverse_linked_list_ii {
    /** Time: O(n)
     * Space: O(1) */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        // preM
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode preM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = mNode.next;

        for (int i = m; i < n; i++) {
            if (postN == null) {
                return null;
            }
            ListNode temp = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = temp;
        }

        // connect preM -> nNode, mNode -> postN
        mNode.next = postN;
        preM.next = nNode;

        return dummy.next;
    }
}
