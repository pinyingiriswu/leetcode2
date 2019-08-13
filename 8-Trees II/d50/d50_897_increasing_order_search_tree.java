public class d50_897_increasing_order_search_tree {
    /** Recursive:
     *  Time: O(n)
     *  Space: O(1) */
    private TreeNode dummy;
    private TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        dummy = new TreeNode(-1);
        cur = dummy;
        helper(root);
        return dummy.right;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        cur.right = root;
        root.left = null;
        cur = cur.right;
        helper(root.right);
    }

    /** Iterative:
     *  Time: O(n)
     *  Space: O(n) */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            cur.right = root;
            root.left = null; // REMEMBER TO ADD!!!
            cur = cur.right;
            root = root.right;
        }
        return dummy.right;
    }
}
