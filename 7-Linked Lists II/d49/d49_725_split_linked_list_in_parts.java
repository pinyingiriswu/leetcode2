public class d49_725_split_linked_list_in_parts {
    /** Time: O(N + k)
     * Space: O(max(N, k)) */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) return res;
        int len = getLength(root);
        int n = len / k;
        int r = len % k;
        int index = 0;
        ListNode cur = root;
        while (cur != null) {
            for (int i = 0; i < k; i++) {
                int p = (r > 0) ? n + 1: n;
                ListNode dummy = new ListNode(-1);
                ListNode temp = dummy;
                for (int j = 0; j < p; j++) {
                    ListNode newNode = new ListNode(cur.val);
                    temp.next = newNode;
                    temp = temp.next;
                    cur = cur.next;
                }
                res[index++] = dummy.next;
                if (r > 0) r--;
            }
        }
        return res;
    }

    private int getLength(ListNode head) {
        if (head == null) return 0;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
