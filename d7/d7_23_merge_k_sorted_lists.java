public class d7_23_merge_k_sorted_lists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            cur.next = top;
            cur = top;
            if (top.next != null) {
                pq.add(top.next);
            }
        }
        return dummy.next;
    }
}
