public class d54_99_recover_binary_search_tree {
    /** Time: O(1) --> best case, O(n) --> worst case if one of the swapped nodes is the rightmost leaf
     * Space: O(h) --> h: the height of the tree */
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null; //track predecessor

        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();

            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) x = pred;
                else break;
            }

            pred = root;
            root = root.right;
        }
        swap(x, y);
    }

    private void swap (TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
