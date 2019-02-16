package tree;

import node.TreeNode;

//输入[1,2]报错，提示结果为2，？？？

public class MinimumDepthOfBT {
    public int minDepth(TreeNode root){



        return depth(root,0);
    }
    private int depth(TreeNode root,int temp){
        if(root!=null){
            temp++;
            int left=depth(root.left,temp);
            int right=depth(root.right,temp);
            return left<right?left:right;
        }else{
            return temp;
        }
    }

}
