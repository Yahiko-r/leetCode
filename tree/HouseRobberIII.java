package tree;

import node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 数组的偷是用dp的思想。
 * 数来说，是按层来分配，1.偷了当前层，下一层不能偷。2.不偷当前层，递归算下一层（左右两个子树）。
  *讨论区赞数最高的评论很好。第三种方法是对第二种方法的空间优化，因为只需要记录两个结果即可，而
 * 第二种方法记录了每个节点的结果
 */
public class HouseRobberIII {
    public int rob(TreeNode root){

        int[] res=robSub(root);
        return Math.max(res[0],res[1]);
    }
    private int[] robSub(TreeNode root){
        if(root==null){
            return new int[2];
        }
        int[] left=robSub(root.left);
        int[] right=robSub(root.right);

        int[] rs=new int[2];
        rs[0]=root.val+left[1]+right[1];
        rs[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return rs;
    }


    public static void main(String[] args) {
        List<List<Integer>> rs=new LinkedList<>();
        if(rs.get(0)==null){
            System.out.println("ok");
        }
    }

}
