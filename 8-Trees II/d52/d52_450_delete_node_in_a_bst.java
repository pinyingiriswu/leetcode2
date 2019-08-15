public class d52_450_delete_node_in_a_bst {
    /** Time: O(logn)
     * Space: O(h) --> h: height of the tree */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        // delete from right tree if key is larger than root value
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // delete from left tree if key is smaller than root value
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // key value equals root value, there are 3 scenarios
        else {
            // the node to be deleted is a leaf
            if (root.left == null && root.right == null) {
                root = null;
            }
            // the node to be deleted has right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node to be deleted has left child
            else if (root.left != null) {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    // successor: next larger node than current node
    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    // predecessor: previous largest node but smaller than current node
    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
