package leetCode;

public class DeleteDuplicate {
	public ListNode deleteDuplicates(ListNode head){
		ListNode newHead=head;
		while(head!=null&&head.next!=null){
			if(head.next.val==head.val){
				head.next=head.next.next;
				continue;
			}
			head=head.next;
		}
		return newHead;
	}
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val=x;}
	}
}
