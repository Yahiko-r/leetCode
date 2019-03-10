package tree;

import node.TreeNode;

public class ConstructBSTFromPreorder {
    public static TreeNode bst(int[] preorder){
        if(preorder==null||preorder.length==0)return null;
        return construct(preorder,0,preorder.length-1);
    }
    private static TreeNode construct(int[] a,int begin,int end){
        if(begin>end)return null;
        int right=end+1;
        TreeNode t=new TreeNode(a[begin]);
        for(int i=begin+1;i<=end;i++){
            if(a[i]>a[begin]){
                right=i;
                break;
            }
        }
        t.left=construct(a,begin+1,right-1);
        t.right=construct(a,right,end);
        return t;
    }

}
