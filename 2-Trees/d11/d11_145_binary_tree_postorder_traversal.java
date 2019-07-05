public class d11_145_binary_tree_postorder_traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode(int x) { val = x; }
         * }
         */
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> st = new LinkedList<>();
        st.add(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pollLast(); // remove last element of the list
            res.addFirst(node.val);
            if (node.left != null) st.add(node.left);
            if (node.right != null) st.add(node.right);
        }

        return res;
    }
}
