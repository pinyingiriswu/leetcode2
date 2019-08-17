public class d54_222_count_complete_tree_nodes {

    /** Naive */
    /** Time: O(n)
     * Space: O(n) */
    public int countNodes(TreeNode root) {
        return root == null ? 0: 1 + countNodes(root.left) + countNodes(root.right);
    }

    /** Binary Search */
    /** Time: O(logn * logn)
     * Space: O(n) */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getLeftDepth(root);
        int rightDepth = getRightDepth(root);

        if (leftDepth == rightDepth) {
            return (int)Math.pow(2, rightDepth + 1) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getLeftDepth(TreeNode root) {
        int count = 0;
        while(root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int getRightDepth(TreeNode root) {
        int count = 0;
        while(root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

}
