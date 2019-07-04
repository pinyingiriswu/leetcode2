public class d10_105_construct_binary_tree_from_preorder_and_inorder_traversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int pre_st, int pre_end, int in_st, int in_end) {
        if (pre_st > pre_end || in_st > in_end) return null;

        TreeNode root = new TreeNode(preorder[pre_st]);
        int rootIdx = in_st;

        while (rootIdx <= in_end) {
            if (inorder[rootIdx] == preorder[pre_st]) {
                break;
            }
            rootIdx++;
        }

        root.left = helper(preorder, inorder, pre_st + 1, pre_st + (rootIdx - in_st), in_st, rootIdx - 1);
        root.right = helper(preorder, inorder, pre_st + (rootIdx - in_st) + 1, pre_end, rootIdx + 1, in_end);

        return root;
    }
}
