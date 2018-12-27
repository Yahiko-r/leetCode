package tree;

import node.TreeNode;

public class RecoverBinarySearchTree {
    private TreeNode first=null;
    private TreeNode second=null;
    private TreeNode pre=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root){
        trversal(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    private void trversal(TreeNode root){
        if(root==null)return;
        trversal(root.left);
        if(first==null&&pre.val>=root.val)
            first=pre;
        if(first!=null&&pre.val>=root.val)
            second=root;
        pre=root;
        trversal(root.right);
    }
}
