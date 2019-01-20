package tree;

import node.TreeNode;

public class DistributeConsInBT {
    private int moves;
    public int distributeCoins(TreeNode root){
        if(root==null)return 0;
        return postOrder(root);
    }
    public int postOrder(TreeNode root){
        if(root==null)return 0;
        int left=postOrder(root.left);
        int right=postOrder(root.right);
        moves+=Math.abs(left)+Math.abs(right);
        return left+right+root.val-1;
    }
}
