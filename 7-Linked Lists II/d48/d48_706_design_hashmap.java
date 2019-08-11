public class d48_706_design_hashmap {

    class MyHashMap {

        class ListNode {
            int key;
            int val;
            ListNode next;
            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
                next = null;
            }
        }

        ListNode[] map;
        int size;

        /** Initialize your data structure here. */
        public MyHashMap() {
            this.size = 1000000;
            this.map = new ListNode[size];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = key % size;
            if (map[index] == null) {
                map[index] = new ListNode(key, value);
            }
            ListNode cur = map[index];
            while (cur.next != null) {
                if (cur.key == key) {
                    cur.val = value;
                    return;
                }
                cur = cur.next;
            }
            if (cur.key == key) {
                cur.val = value;
                return;
            }
            cur.next = new ListNode(key, value);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = key % size;
            if (map[index] == null) {
                return -1;
            }

            ListNode cur = map[index];
            while (cur != null) {
                if (cur.key == key) {
                    return cur.val;
                }
                cur = cur.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = key % size;
            if (map[index] == null) {
                return;
            }

            ListNode cur = map[index];
            if (cur.key == key) {
                map[index] = cur.next;
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
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
