public class d46_2_add_two_numbers {
    /** Time: O(n)
     * Space: O(n) */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int sum = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int digit = sum % 10;
            sum = sum / 10;
            ListNode newNode = new ListNode(digit);
            cur.next = newNode;
            cur = cur.next;
        }

        if (sum == 1) cur.next = new ListNode(1);

        return dummy.next;
    }
}
