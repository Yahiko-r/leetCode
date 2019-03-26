package tree;

import node.TreeNode;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        convert(root,0);
        return root;
    }
    private int convert(TreeNode root,int parent){
        if(root==null){
            return parent;
        }
        int right=convert(root.right,parent);
        root.val+=right;
        int left=convert(root.left,root.val);

        return left;


    }


}
