package tree;

import node.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;

        if (head(s, t)) return true;

        boolean left = isSubtree(s.right, t);
        boolean right = isSubtree(s.left, t);
        return left || right;
    }

    private boolean head(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (s.val != t.val) return false;
        boolean left = head(s.left, t.left);
        boolean right = head(s.right, t.right);
        return left && right;
    }
}
