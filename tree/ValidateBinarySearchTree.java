package tree;

import node.TreeNode;

public class ValidateBinarySearchTree {
    private TreeNode pre=null;
    public boolean isValidBST(TreeNode root) {
        return trversal(root);
    }

    private boolean trversal(TreeNode root) {
        if (root == null) return true;
        boolean left=trversal(root.left);
        if(left==false)return false;
        if(pre!=null&&pre.val>=root.val)return false;
        pre=root;
        boolean right=trversal(root.right);
        return right;
    }
}
