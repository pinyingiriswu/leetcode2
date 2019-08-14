public class d51_105_construct_binary_tree_from_preorder_and_inorder_traversal {
    /** Time: O(n^2) --> need to traverse inorder[] for each node again to find rootIndex
     * Space: O(n) */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        int preLen = preorder.length;
        int inLen = inorder.length;
        return helper(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inStart;
        while (rootIndex <= inEnd) {
            if(inorder[rootIndex] == rootVal) {
                break;
            }
            rootIndex++;
        }
        TreeNode left = helper(preorder, preStart + 1, preStart + (rootIndex - inStart), inorder, inStart, rootIndex - 1);
        TreeNode right = helper(preorder, preStart + (rootIndex - inStart) + 1, preEnd, inorder, rootIndex + 1, inEnd);

        root.left = left;
        root.right = right;

        return root;
    }
}
