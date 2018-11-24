import java.util.ArrayList;
import java.util.List;

public class BTInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){

        List<Integer> rs=new ArrayList<>();
        if(root==null)return rs;
       subTreeNode(root,rs);
       return rs;
    }
    public void subTreeNode(TreeNode root,List<Integer> rs){

        if(root.left!=null){
            subTreeNode(root.left,rs);
        }
        rs.add(root.val);
        if(root.right!=null){
            subTreeNode(root.right,rs);
        }
    }
}

