public class d12_103_binary_tree_zigzag_order_traversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty() || !st2.isEmpty()) {
            List<Integer> temp1 = new ArrayList<>();
            while (!st1.isEmpty()) {
                TreeNode top = st1.pop();
                temp1.add(top.val);
                if (top.left != null) st2.push(top.left);
                if (top.right != null) st2.push(top.right);
            }
            if (!temp1.isEmpty()) res.add(temp1);

            List<Integer> temp2 = new ArrayList<>();
            while (!st2.isEmpty()) {
                TreeNode top = st2.pop();
                temp2.add(top.val);
                if (top.right != null) st1.push(top.right);
                if (top.left != null) st1.push(top.left);
            }
            if (!temp2.isEmpty()) res.add(temp2);
        }

        return res;
    }
}
