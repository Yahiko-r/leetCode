package list;

import node.ListNode;

public class SortList {
    public ListNode sortList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=findMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left,right);

    }
    public ListNode findMid(ListNode node){
        ListNode fast=node;
        ListNode slow=node;
        ListNode p=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next;
            fast=fast.next;
            if(fast==null||fast.next==null){
                p=slow;
            }
            slow=slow.next;
        }
        p.next=null;
        return slow;
    }
    public ListNode merge(ListNode one,ListNode two){

        ListNode p=new ListNode(0);
        ListNode head=p;
        while(one!=null&&two!=null){
            if(one.val>two.val){
                head.next=two;
                two=two.next;
            }
            else{
                head.next=one;
                one=one.next;

            }
            head=head.next;

        }
        if(one==null){
            head.next=two;
        }else{
            head.next=one;
        }
        return p.next;



    }
}
