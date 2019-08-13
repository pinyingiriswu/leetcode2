public class d50_872_leaf_similar_trees {

    List<Integer> res1 = new ArrayList<>();
    List<Integer> res2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        helper(root1, res1);
        helper(root2, res2);

        return res1.equals(res2);
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        helper(root.left, res);
        helper(root.right, res);
    }
}
