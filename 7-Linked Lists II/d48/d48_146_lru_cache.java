public class d48_146_lru_cache {

    class LRUCache {

        private class ListNode {
            int key;
            int value;
            ListNode prev;
            ListNode next;
            ListNode(int key, int value) {
                this.key = key;
                this.value = value;
                prev = next = null;
            }
        }

        Map<Integer, ListNode> map;
        private ListNode head;
        private ListNode tail;
        int capacity;

        public LRUCache(int capacity) {
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            ListNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (map.size() == capacity) {
                    ListNode rmNode = tail.prev;
                    removeNode(rmNode);
                    map.remove(rmNode.key);
                }
                ListNode newNode = new ListNode(key, value);
                map.put(key, newNode);
                addToHead(newNode);
            }
            ListNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
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
            node.next = node.prev = null;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
