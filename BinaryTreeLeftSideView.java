// Left View of Binary Tree
import java.util.*;

class BinaryTreeLeftSideView {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (i == 0) {
                    // First node of this level = leftmost
                    result.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
