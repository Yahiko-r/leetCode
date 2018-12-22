package tree;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> rs=new ArrayList<>();
        int level=0;
        add(rs,root,level);
        return rs;
    }
    public void add(List<List<Integer>> rs,TreeNode root,int level){
        if(root==null)return;
        if(rs.size()<=level){
            List<Integer> list=new ArrayList<>();
            list.add(root.val);
            rs.add(list);
        }else{
            rs.get(level).add(root.val);
        }
        add(rs,root.left,level+1);
        add(rs,root.right,level+1);
    }

    public static void main(String[] args) {
        BTLevelOrderTraversal b=new BTLevelOrderTraversal();

    }
}
