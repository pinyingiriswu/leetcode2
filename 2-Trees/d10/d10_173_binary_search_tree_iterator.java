public class d10_173_binary_search_tree_iterator {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
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
}
