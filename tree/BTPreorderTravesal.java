package tree;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTPreorderTravesal {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> rs=new ArrayList<>();
        preorder(root,rs);
        return rs;
    }
    private void preorder(TreeNode node,List<Integer> rs){
        if(node!=null){
            rs.add(node.val);
            preorder(node.left,rs);
            preorder(node.right,rs);
        }
    }
}
