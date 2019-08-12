public class d49_430_flatten_a_multilevel_doubly_linked_list {
    /** Time: O(N)
     * Space: O(1) */
    public Node flatten(Node head) {
        if (head == null) return head;
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
                if (nextNode != null) nextNode.prev = childNode;
            }
            head = head.next;
        }
        return cur;
    }
}
