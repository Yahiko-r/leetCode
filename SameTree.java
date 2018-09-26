import javax.swing.tree.TreeNode;

public class SameTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flagL=false,flagR=false;
        if(p==null&&q==null)return true;
        if (p!=null&&q!=null&&p.val == q.val) {
            flagL = isSameTree(p.left, q.left);
            flagR = isSameTree(p.right, q.right);
        }
        if(flagL==true&&flagR==true)return true;

        return false;

    }
}
