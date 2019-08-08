public class d45_160_intersection_of_two_linked_lists {
    /** Time: O(m + n)
     * Space: O(1) */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode pA = headA;
        ListNode pB = headB;

        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                pA = pA.next;
                diff--;
            }
        }

        if (lenB > lenA) {
            int diff = lenB - lenA;
            while (diff > 0) {
                pB = pB.next;
                diff--;
            }
        }

        while (pA != null && pB != null) {
            if (pA == pB) {
                break;
            }
            pA = pA.next;
            pB = pB.next;
        }

        return pA;

    }

    private int getLength(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int len = 0;

        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
