package list;

import node.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)return;
        //find middle
        ListNode fast = head;
        ListNode slow = head;
        ListNode p=null;
        while (fast != null && fast.next != null) {
            p=slow;
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        p.next=null;
        ListNode second = slow;
        //reverse
        ListNode pre = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = pre;
            pre = second;
            second = next;
        }

        //combine two list
        ListNode newHead = head;
        while (newHead != null && pre != null) {
            ListNode next1 = newHead.next;
            ListNode next2 = pre.next;
            newHead.next = pre;
            if (next1 != null)
                pre.next = next1;
            else{
                break;
            }
            newHead = next1;
            pre = next2;
        }
    }

    public static void main(String[] args) {
        int i=0;
        ListNode head=new ListNode(0);
        ListNode h=head;
        while(i<5){
            i++;
            ListNode node=new ListNode(i);
            head.next=node;
            head=head.next;
        }
        ReorderList r=new ReorderList();
        r.reorderList(h);
        while(h!=null){
            System.out.println(h.val);
            h=h.next;
        }
    }
}
