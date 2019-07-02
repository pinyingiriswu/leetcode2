public class d5_445_add_two_numbers_ii {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        Stack<Integer> res = new Stack<Integer>();

        while (l1 != null) {
            st1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            st2.push(l2.val);
            l2 = l2.next;
        }

        int n1, n2, carry = 0;

        while (!st1.isEmpty() || !st2.isEmpty() || carry > 0) {
            n1 = st1.isEmpty() ? 0: st1.pop();
            n2 = st2.isEmpty() ? 0: st2.pop();
            res.push((n1 + n2 + carry) % 10);
            carry = (n1 + n2 + carry) / 10;
        }

        ListNode cur = new ListNode(res.pop());
        ListNode head = cur;

        while (!res.isEmpty()) {
            cur.next = new ListNode(res.pop());
            cur = cur.next;
        }

        return head;
    }
}
