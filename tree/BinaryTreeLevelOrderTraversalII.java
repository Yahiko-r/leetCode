package tree;

import ioc.Tree;
import node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levleorderBottom(TreeNode root){
        List<List<Integer>> rs=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)return rs;
        queue.offer(root);
        while(!queue.isEmpty()){
            int s=queue.size();
            List<Integer> list=new LinkedList<>();
            for(int i=0;i<s;i++){
                if(queue.peek().left!=null)queue.offer(queue.peek().left);
                if(queue.peek().right!=null)queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            rs.add(0,list);
        }
        return rs;
    }
}
