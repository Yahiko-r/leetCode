package tree;

import node.TreeNode;

public class FlattenBTToLinkedList {
    private TreeNode prev=null;
    public void flatten(TreeNode root){
        if(root==null)return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
    /**
     * 曲解了题目的意思，拉平之后不用排序，只需要从下至上，把左子树移到右子树就行了
     * 这里假设了节点一定比儿子小，并且拉平之后是排好序的
     * @param root
     */
    public void flatten2(TreeNode root) {
        if(root==null)return;
        TreeNode p = root;
        //从下往上
        sortLeftOfRight(p,root);
        }

    private void sortAll(TreeNode root,TreeNode node) {
        if(node.left!=null){
            sortAll(root,node.left);
        }
        if(node.right!=null){
            sortAll(root,node.right);
        }
        node.left=null;
        node.right=null;
        sort(root,node);
    }

    private void sortLeftOfRight(TreeNode root,TreeNode old) {
        if (root.right != null) {
            sortLeftOfRight(root.right,old);
        }
        if (root.left != null) {
            sortAll(root,root.left);
            root.left=null;
        }

    }
    //假设节点一定比儿子小
    private TreeNode sort(TreeNode root, TreeNode node) {
        if(root==null){
            return node;
        }
        if (node.val < root.val) {
            node.left = null;
            node.right = root;
            return node;
        }

        root.right = sort(root.right, node);

        return root;
    }
}
