package tree;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlipBTMatchPreorderTraversal {
    private int pos = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> rs = new ArrayList<>();
        if (dfs(root, voyage, rs)) {
            return rs;
        } else{
            List<Integer> err=new ArrayList<>();
            err.add(-1);
            return err;
        }

    }
    private boolean dfs(TreeNode root, int[] voyage, List<Integer> rs) {
        if (root == null) return true;
        if (root.val != voyage[pos++]) return false;
        if (root.left != null && root.right != null) {
            if (root.right.val == voyage[pos]) {
                rs.add(root.val);
                return dfs(root.right, voyage, rs) && dfs(root.left, voyage, rs);
            }
            return dfs(root.left, voyage, rs) && dfs(root.right, voyage, rs);
        } else {
            return dfs(root.left, voyage, rs) && dfs(root.right, voyage, rs);
        }
    }

    public static void main(String[] args) {
        FlipBTMatchPreorderTraversal f=new FlipBTMatchPreorderTraversal();
        TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(3);
        root.left=left;
        root.right=right;
        int[] voy=new int[]{1,3,2};
        List<Integer> rs=f.flipMatchVoyage(root,voy);
        for(int i=0;i<rs.size();i++){
            System.out.println(rs.get(i));
        }
    }
}
