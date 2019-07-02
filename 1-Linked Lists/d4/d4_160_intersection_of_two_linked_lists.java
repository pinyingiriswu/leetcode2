public class d4_160_intersection_of_two_linked_lists {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != null) {
            lenA++;
            pA = pA.next;
        }

        while (pB != null) {
            lenB++;
            pB = pB.next;
        }

        pA = headA;
        pB = headB;

        if (lenA > lenB) {
            int diff = lenA - lenB;
            for (int i = 0; i < diff; i++) {
                pA = pA.next;
            }
        } else {
            int diff = lenB - lenA;
            for (int i = 0; i < diff; i++) {
                pB = pB.next;
            }
        }

        while (pA != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}
