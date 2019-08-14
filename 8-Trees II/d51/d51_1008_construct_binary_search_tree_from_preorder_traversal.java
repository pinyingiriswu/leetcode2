public class d51_1008_construct_binary_search_tree_from_preorder_traversal {
    /** Time: O(n)
     * Space: O(n) */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        int preLen = preorder.length;
        return helper(preorder, 0, preLen - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;
        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);
        if (start == end) return root;
        int breakIdx = start + 1;
        while (breakIdx <= end && preorder[breakIdx] < rootVal) {
            breakIdx++;
        }
        root.left = helper(preorder, start + 1, breakIdx - 1);
        root.right = helper(preorder, breakIdx, end);

        return root;
    }
}
