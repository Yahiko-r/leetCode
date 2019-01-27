package tree;

import node.TreeNode;

public class ConstructBTFromPreOrderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) return null;
        int postion = 0;
        return construct(preorder,0,inorder,0,preorder.length-1);
    }

    private TreeNode construct(int[] preorder, int pos, int[] inorder, int begin, int end) {
        if (pos >= preorder.length) return null;
        if(begin>end)return null;
        TreeNode head = new TreeNode(preorder[pos]);
        for (int i = begin; i <= end; i++) {
            if (inorder[i] == preorder[pos]) {
                int leftLength=i-begin;
                head.right = construct(preorder, pos + leftLength+1, inorder, i + 1, end);
                head.left = construct(preorder, pos + 1, inorder, begin, i - 1);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ConstructBTFromPreOrderAndInorder c=new ConstructBTFromPreOrderAndInorder();
        int[] pre={3,9,20,15,7};
        int[] in={9,3,15,20,7};
        TreeNode t=c.buildTree(pre,in);
        System.out.println("end");;
    }
}
