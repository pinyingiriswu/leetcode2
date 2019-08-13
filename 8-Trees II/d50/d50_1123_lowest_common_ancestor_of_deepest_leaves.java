public class d50_1123_lowest_common_ancestor_of_deepest_leaves {
    /** Time: O(n)
     *  Space: O(n) */

    private int maxDepth;
    private TreeNode lca;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        lca = root;
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
            lca = node;
        }

        int maxLeft = helper(node.left, depth + 1);
        int maxRight = helper(node.right, depth + 1);

        if (maxDepth == maxLeft && maxDepth == maxRight) {
            lca = node;
        }

        return Math.max(depth, Math.max(maxLeft, maxRight));
    }
}
