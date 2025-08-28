// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class InorderTraversal {
    // Recursive inorder
    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);         // Left
        System.out.print(root.val + " "); // Root
        inorder(root.right);        // Right
    }

    public static void main(String[] args) {
        // Example tree:
        //       1
        //        \
        //         2
        //        /
        //       3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        InorderTraversal obj = new InorderTraversal();
        obj.inorder(root);  // Output: 1 3 2
    }
}
