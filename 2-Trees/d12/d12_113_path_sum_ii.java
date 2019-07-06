public class d12_113_path_sum_ii {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        traverse(root, res, temp, sum);
        return res;
    }

    private void traverse(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum) {
        if (root == null) return;
        temp.add(root.val);

        if (sum == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
        }

        traverse(root.left, res, temp, sum - root.val);
        traverse(root.right, res, temp, sum - root.val);

        // remove last element
        temp.remove(temp.size()-1);
    }
}
