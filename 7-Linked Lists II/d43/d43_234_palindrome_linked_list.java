public class d43_234_palindrome_linked_list {
    /** Time: O(n)
     * Space: O(1) */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid = findMid(head);
        mid = reverse(mid);

        while (head != null && mid != null) {
            if (head.val != mid.val) {
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;
    }

    private ListNode findMid(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
