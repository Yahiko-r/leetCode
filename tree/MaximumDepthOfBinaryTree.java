package tree;

import node.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root){
        TreeNode p=root;
        Integer depth=0;
        if(root==null)return 0;
        return midOrder(root,depth);
    }
    private int midOrder(TreeNode head,int depth){
        if(head==null){
            return depth;
        }
        depth++;
        int left=midOrder(head.left,depth);
        int right=midOrder(head.right,depth);
        return Math.max(left,right);

    }
}
