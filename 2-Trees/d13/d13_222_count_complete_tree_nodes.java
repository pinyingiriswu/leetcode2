public class d13_222_count_complete_tree_nodes {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    /** Reference: https://www.acwing.com/solution/LeetCode/content/89/ */

    /** Naive */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /** O(logN * logN) time complexity */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getLeftDepth(root);
        int rightDepth = getRightDepth(root);

        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, rightDepth+1) - 1;
        }
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public int getLeftDepth(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    public int getRightDepth(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            root = root.right;
            count++;
        }
        return count;
    }
}
