public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head,int n){
        int l=1;
        ListNode p=head;
        while(p.next!=null){
            l++;
            p=p.next;
        }
        p=head;
        for(int i=1;i<l-n;i++){
            p=p.next;
        }
        p.next=p.next.next;
        return head;
    }



    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

  public ListNode getList(){
        ListNode[] la=new ListNode[5];
        la[0]=new ListNode(0);
        for(int i=1;i<5;i++){
            la[i]=new ListNode(i);
            la[i].next=la[i-1];
        }
        return la[4];
  }
    public static void main(String[] args) {
        Solution19 s =new Solution19();
       ListNode head=s.getList();
        ListNode rs=s.removeNthFromEnd(head,2);
        for(int i=0;i<4;i++){
            System.out.println(rs.val);
            rs=rs.next;
        }
    }
}
