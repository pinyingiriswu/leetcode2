public class d3_143_reorder_list {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode m = findMid(head);
        ListNode n = reverseList(m.next);
        m.next = null;

        merge(head, n);
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
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

    private void merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        int index = 0;

        while (h1 != null && h2 != null) {
            if (index % 2 == 0) {
                dummy.next = h1;
                h1 = h1.next;
            } else {
                dummy.next = h2;
                h2 = h2.next;
            }
            dummy = dummy.next;
            index++;
        }

        if (h1 != null) {
            dummy.next = h1;
        }

        if (h2 != null) {
            dummy.next = h2;
        }
    }
}
