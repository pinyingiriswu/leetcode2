public class d13_99_recover_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public void recoverTree(TreeNode root) {
        // Use ArrayDeque to implement stack instead of Stack
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null; // track last node (predecessor)
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.add(root);
                root = root.left;
            }

            root = st.removeLast();

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

    public void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
