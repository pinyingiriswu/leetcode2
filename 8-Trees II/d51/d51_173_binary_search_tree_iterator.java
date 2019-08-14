public class d51_173_binary_search_tree_iterator {

    class BSTIterator {

        Stack<TreeNode> st;

        public BSTIterator(TreeNode root) {
            st = new Stack<>();
            while (root != null) {
                st.push(root);
                root = root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode top = st.pop();
            int num = top.val;
            if (top.right != null) {
                TreeNode right = top.right;
                while (right != null) {
                    st.push(right);
                    right = right.left;
                }
            }
            return num;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !st.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
