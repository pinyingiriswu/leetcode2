public class d52_145_binary_tree_postorder_traversal {
    /** Recursive*/
    /** Time: O(n)
     * Space: O(n) */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    /** Iterative 1*/
    /** Time: O(n)
     * Space: O(n) */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> st = new LinkedList<>();
        st.add(root);

        while(!st.isEmpty()) {
            TreeNode node = st.pollLast();
            res.addFirst(node.val);
            if (node.left != null) st.add(node.left);
            if (node.right != null) st.add(node.right);
        }
        return res;
    }


    /** Iterative 2: RIGHT preorder traversal, then reverse the order of output*/
    /** Time: O(n)
     * Space: O(n) */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode top = st.pop();
            res.addFirst(top.val);
            if (top.left != null) st.push(top.left);
            if (top.right != null) st.push(top.right);
        }
        return res;
    }
}
