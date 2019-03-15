package tree;

import node.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root){
        if(root==null)return null;
        TreeNode p=null;
        if(root.left==null&&root.right==null){
            return root;
        }else {
            p=root.right;
            root.right=root.left;
            root.left=p;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
