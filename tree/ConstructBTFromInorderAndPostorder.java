package tree;

import node.TreeNode;

public class ConstructBTFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null) return null;

        return construct(postorder, postorder.length - 1, inorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] postorder, int pos, int[] inorder, int begin, int end) {
        if (pos >= postorder.length) return null;
        if (begin > end) return null;
        TreeNode head = new TreeNode(postorder[pos]);
        for (int i = begin; i <= end; i++) {
            if (inorder[i] == postorder[pos]) {
                int leftLength = end - i + 1;
                head.right = construct(postorder, pos-1, inorder, i + 1, end);
                head.left = construct(postorder, pos - leftLength, inorder, begin, i - 1);
            }
        }
        return head;

    }
}
