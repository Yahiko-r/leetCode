import java.util.LinkedList;
import java.util.List;

public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n){
        return genTree(1,n);
    }
    public List<TreeNode> genTree(int s,int n){
        List<TreeNode> rs=new LinkedList<>();
        if(s>n){
            rs.add(null);
        }
        for(int i=s;i<=n;i++){
            List<TreeNode> leftTree=genTree(s,i-1);
            List<TreeNode> rightTree=genTree(i+1,n);
            for(TreeNode leftNode:leftTree){
                for(TreeNode rightNode:rightTree){
                    TreeNode root=new TreeNode(i);
                    root.left=leftNode;
                    root.right=rightNode;
                    rs.add(root);
                }
            }
        }
        return rs;
    }
}
class  TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x){val=x;}
}
