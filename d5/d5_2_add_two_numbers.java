public class d5_2_add_two_numbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
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

            cur.next = new ListNode(sum % 10);
            sum /= 10; // for carry
            cur = cur.next;
        }

        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
