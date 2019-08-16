public class d53_113_path_sum_ii {
    /** Time: O(n)
     * Space: O(n) */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> temp = new ArrayList<>();
        helper(root, sum, temp, res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (root == null) return;
        temp.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
        }
        helper(root.left, sum - root.val, temp, res);
        helper(root.right, sum - root.val, temp, res);

        temp.remove(temp.size()-1); // remove last element for backtracking
    }
}
