package tree;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root,int sum){
        List<List<Integer>> rs=new ArrayList<>();
        if(root==null)return rs;
        path(root,sum,rs,new ArrayList<>());
        return rs;
    }
    private void path(TreeNode root,int sum,List<List<Integer>> rs,List<Integer> temp){
        if(root==null)return ;
        temp.add(root.val);
        if(sum-root.val==0&&root.left==null&&root.right==null){
            rs.add(temp);
        }
        path(root.left,sum-root.val,rs,new ArrayList<>(temp));
        path(root.right,sum-root.val,rs,new ArrayList<>(temp));
    }
}
