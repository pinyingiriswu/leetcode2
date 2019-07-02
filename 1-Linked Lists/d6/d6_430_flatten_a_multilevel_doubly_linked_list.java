public class d6_430_flatten_a_multilevel_doubly_linked_list {
    /**
    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
    */

    /** References:
     * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/311772/Java-recursive-solution-(0ms-36.7MB)-with-comments-O(n)-time-complexity-O(n)-space
     * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/318235/Java-Recursive-Solution*/
    public Node flatten(Node head) {
        Node cur = head;
        while (head != null) {
            if (head.child != null) {
                Node childNode = flatten(head.child);
                Node nextNode = head.next;
                head.next = childNode;
                childNode.prev = head;
                head.child = null;
                while (childNode.next != null) {
                    childNode = childNode.next;
                }
                childNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = childNode;
                }
            }
            head = head.next;
        }
        return cur;
    }
}
