public class d51_951_flip_equivalent_binary_trees {
    /** Time: O(min(n1, n2)) --> n1: length of root1, n2: length of root2
     * Space: O(min(h1, h2)) --> h1: height of root1, h2: height of root2 */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
