public class d7_146_lru_cache {

    /** Reference: https://www.cnblogs.com/springfor/p/3869393.html
     * “为了能够快速删除最久没有访问的数据项和插入最新的数据项，我们将双向链表连接Cache中的数据项，
     * 并且保证链表维持数据项从最近访问到最旧访问的顺序。 每次数据项被查询到时，都将此数据项移动到
     * 链表头部（O(1)的时间复杂度）。这样，在进行过多次查找操作后，最近被使用过的内容就向链表的头移动，
     * 而没有被使用的内容就向链表的后面移动。当需要替换时，链表最后的位置就是最近最少被使用的数据项，
     * 我们只需要将最新的数据项放在链表头部，当Cache满时，淘汰链表最后的位置就是了。 ”
     *
     * 原则就是：对链表有访问，就要更新链表顺序。
     * */

    class LRUCache {

        private ListNode head;
        private ListNode tail;
        int capacity;
        Map<Integer, ListNode> map;

        public LRUCache(int capacity) {
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            map = new HashMap<>();
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            } else {
                ListNode node = map.get(key);
                removeNode(node);
                addToHead(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() >= capacity) {
                    ListNode rmNode = tail.prev;
                    removeNode(rmNode);
                    map.remove(rmNode.key);
                }
                ListNode newNode = new ListNode(key, value);
                addToHead(newNode);
                map.put(key, newNode);
            } else {
                ListNode node = map.get(key);
                node.value = value;
                removeNode(node);
                addToHead(node);
            }
        }

        private void addToHead(ListNode node) {
            ListNode next = head.next;
            node.prev = head;
            node.next = next;
            head.next = node;
            next.prev = node;
        }

        private void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = node.next = null;
        }

        private class ListNode {
            int key;
            int value;
            ListNode prev;
            ListNode next;

            ListNode(int key, int value){
                this.key = key;
                this.value = value;
                prev = next = null;
            }
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
