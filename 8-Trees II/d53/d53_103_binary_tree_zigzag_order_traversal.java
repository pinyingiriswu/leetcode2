public class d53_103_binary_tree_zigzag_order_traversal {
    /** Time: O(n)
     * Space: O(n) */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while(!st1.isEmpty() || !st2.isEmpty()) {
            if (!st1.isEmpty()) {
                int size = st1.size();
                List<Integer> temp1 = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = st1.pop();
                    temp1.add(node.val);
                    if (node.left != null) st2.push(node.left);
                    if (node.right != null) st2.push(node.right);
                }
                res.add(temp1);
            }

            if (!st2.isEmpty()) {
                int size = st2.size();
                List<Integer> temp2 = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = st2.pop();
                    temp2.add(node.val);
                    if (node.right != null) st1.push(node.right);
                    if (node.left != null) st1.push(node.left);
                }
                res.add(temp2);
            }
        }
        return res;
    }
}
