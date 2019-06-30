public class d6_707_design_linked_list {

    class MyLinkedList {

        class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }

        private int size;
        private ListNode dummy;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            dummy = new ListNode(0);
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode temp = dummy;
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            ListNode nextNode = dummy.next;
            newNode.next = nextNode;
            dummy.next = newNode;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode newNode = new ListNode(val);
            ListNode temp = dummy;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            ListNode newNode = new ListNode(val);

            if (index <= size) {
                ListNode temp = dummy;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
            } else {
                return;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                ListNode temp = dummy;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            } else {
                return;
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
