import java.util.List;
import java.util.ArrayList;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);       // Root
        dfs(node.left, res);     // Left
        dfs(node.right, res);    // Right
    }
}
