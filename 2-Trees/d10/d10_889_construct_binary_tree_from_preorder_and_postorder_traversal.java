public class d10_889_construct_binary_tree_from_preorder_and_postorder_traversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length != post.length) return null;
        return helper(pre, post, 0, pre.length-1, 0, post.length-1);
    }

    private TreeNode helper(int[] pre, int[] post, int pre_st, int pre_end, int po_st, int po_end) {
        if (pre_st > pre_end || po_st > po_end) return null;
        TreeNode root = new TreeNode(post[po_end]);
        if (po_st == po_end) return root;
        int rightVal = post[po_end-1];
        int rightIdx = pre_end;

        while (rightIdx >= 0) {
            if (pre[rightIdx] == rightVal) {
                break;
            }
            rightIdx--;
        }

        root.left = helper(pre, post, pre_st+1, rightIdx-1, po_st, po_st+(rightIdx - 2 - pre_st));
        root.right = helper(pre, post, rightIdx, pre_end, po_st+(rightIdx - 1 - pre_st), po_end-1);

        return root;
    }
}
