package tree;

import node.TreeNode;

public class MergeTwoBT {
    public TreeNode mergeTrees(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null){
            return null;
        }
        if(t1==null){
            t2.left=mergeTrees(t2.left,null);
            t2.right=mergeTrees(t2.right,null);
            return t2;
        }else if(t2==null){
            t1.left=mergeTrees(t1.left,null);
            t1.right=mergeTrees(t1.right,null);
            return t1;
        }
        t1.val=t1.val+t2.val;
        t1.right=mergeTrees(t1.right,t2.right);
        t1.left=mergeTrees(t1.left,t2.left);
        return t1;

    }
}
