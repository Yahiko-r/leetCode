class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        else if(root.left==null&&root.right==null)return true;
        else if(root.left!=null&&root.right!=null)return compareSubtree(root.left,root.right);
        else return false;
        
    }
    public boolean compareSubtree(TreeNode l,TreeNode r){
        boolean left,right;
        if(l.val!=r.val)return false;
        if(l.left!=null&&r.right!=null){
            
            if(l.left.val==r.right.val) left= compareSubtree(l.left,r.right);
            else return false;
        }
        else if(l.left==null&&r.right==null){left=true;}
        else return false;
        if(l.right!=null&&r.left!=null){
            if(l.right.val==r.left.val) right= compareSubtree(l.right,r.left);
            else 
                return false;
        }
        else if(l.right==null&&r.left==null){right=true;}
        else return false;
        return left&right;
    }
}