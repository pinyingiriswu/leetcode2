public class d8_543_diameter_of_binary_tree {
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
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int dist = left + right;
        res = Math.max(res, dist);
        return Math.max(left, right) + 1;
    }
}
