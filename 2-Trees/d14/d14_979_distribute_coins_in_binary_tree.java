public class d14_979_distribute_coins_in_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    /** Reference: https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/275915/Extensive-explanation-with-Java-code */
    /** construct excess number (can be negative) from leaf nodes up  */
    public int dfs(TreeNode root) {
        /**  For each node, recursively consider contribution from leftSubTree && rightSubtrees.
         The coins that need to be pushed up to its parent would be:
         excess = coins pushed up from left subtree
         + coins pushed up from right subtree
         + node.val
         - 1;
            E.g.
                2 <- root
               / \
              2  0
         left=1 (1 push up from left tree),
         right=-1 (can push down 1 to the right tree)
         excess of cur node = left+right+node.val-1 = 1+(-1)+2-1=1
         */

        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        res += Math.abs(left) + Math.abs(right);

        return left + right + root.val - 1;
    }
}
