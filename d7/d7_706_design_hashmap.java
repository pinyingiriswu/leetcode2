public class d7_706_design_hashmap {

    /** Reference:
     * https://leetcode.com/problems/design-hashmap/discuss/322787/Java-Solution-64ms
     * https://leetcode.com/problems/design-hashmap/discuss/323236/java*/

    class MyHashMap {

        ListNode[] map;
        int size;

        /** Initialize your data structure here. */
        public MyHashMap() {
            size = 10000;
            map = new ListNode[size];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int idx = key % size;
            if (map[idx] == null) {
                map[idx] = new ListNode(key, value);
            }
            ListNode cur = map[idx];
            while (cur.next != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                cur = cur.next;
            }
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur.next = new ListNode(key, value);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int idx = key % size;
            if (map[idx] == null) {
                return -1;
            }
            ListNode cur = map[idx];
            while (cur != null) {
                if (cur.key == key) {
                    return cur.value;
                }
                cur = cur.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int idx = key % size;
            if (map[idx] == null) return;
            ListNode cur = map[idx];
            if (cur.key == key) {
                map[idx] = cur.next;
                return;
            }
            ListNode p = cur;
            while (p.next != null) {
                if (p.next.key == key) {
                    p.next = p.next.next;
                    return;
                }
                p = p.next;
            }
        }

        private class ListNode {
            int key;
            int value;
            ListNode next;
            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
                next = null;
            }
        }

    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
