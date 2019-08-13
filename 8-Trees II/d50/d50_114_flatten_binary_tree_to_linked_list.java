public class d50_114_flatten_binary_tree_to_linked_list {
    /** Time: O(n)
     * Space: O(1) */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;

        TreeNode cur = root;

        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
