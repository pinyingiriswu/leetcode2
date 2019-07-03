public class d9_114_flatten_binary_tree_to_linked_list {
    /** Recursive */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = null;
        root.right = l;

        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = r;
    }

    /** Iterative */
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode top = st.pop();
            if (top.right != null) {
                st.push(top.right);
            }
            if (top.left != null) {
                st.push(top.left);
            }
            if (!st.isEmpty()) {
                top.right = st.peek();
            }
            top.left = null;
        }
    }
}
