public class d14_129_sum_root_to_leaf_numbers {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int num = 0;
        return dfs(root, num);
    }

    public int dfs(TreeNode root, int num) {
        num = num*10 + root.val;
        if (root.left == null && root.right == null) return num;
        int sum = 0;
        if (root.left != null) sum += dfs(root.left, num);
        if (root.right != null) sum += dfs(root.right, num);
        return sum;
    }
}
