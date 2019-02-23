package tree;

import java.util.LinkedList;

class Node{
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node(){}
    public Node(int _val,Node _left,Node _right,Node _next){
        val=_val;
        left=_left;
        right=_right;
        next=_next;
    }
}
public class PopulatingNextRightPointer {
    public Node connect(Node root){
        if(root==null)return null;
        int numNow=1;
        int numNext=0;

        LinkedList<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(queue.size()!=0){
            Node node=queue.poll();
            numNow--;
            if(node.left!=null){
                queue.offer(node.left);

                queue.offer(node.right);
                numNext+=2;
            }
            if(numNow==0){
                numNow=numNext;
                numNext=0;
                node.next=null;
            }else{
                node.next=queue.peek();
            }
        }
        return root;
    }
    //评论区的方法
    /*
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;

                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
    */
}
