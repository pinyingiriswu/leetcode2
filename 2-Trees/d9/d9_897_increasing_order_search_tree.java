public class d9_897_increasing_order_search_tree {
    /** Recursive */
    private TreeNode dummy;
    private TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        dummy = new TreeNode(-1);
        cur = dummy;
        traverse(root);

        return dummy.right;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        cur.right = root;
        root.left = null;
        cur = cur.right;
        traverse(root.right);

    }

    /** Iterative */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return root;

        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;
        Stack<TreeNode> st = new Stack<>();

        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            cur.right = new TreeNode(root.val);
            cur = cur.right;
            root = root.right;
        }
        return dummy.right;
    }
}
