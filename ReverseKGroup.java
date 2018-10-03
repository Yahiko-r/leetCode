package leetCode;

public class ReverseKGroup {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode pro = null, cur = head, next;

		int length = 1;

		while (head.next != null) {
			length++;
			head = head.next;
		}
		int loop = length / k;
		ListNode[] ln = new ListNode[loop];
		ListNode newHead = null;
		int j = 0;
		while (j < loop) {
			ln[j] = cur;
			int i = 0;
			while (i < k) {
				next = cur.next;
				cur.next = pro;
				pro = cur;
				cur = next;
				i++;
			}
			if (j > 0)
				ln[j - 1].next = pro;
			if (j == 0) {
				newHead = pro;
			}
			j++;
		}
		if (j == 0)
			ln[0].next = cur;
		return newHead;
	}

	public void test() {

		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		ListNode rs = reverseKGroup(p1, 2);
		while (rs != null) {
			System.out.println(rs.val);
			rs = rs.next;
		}

	}

	public static void main(String[] args) {
		ReverseKGroup r = new ReverseKGroup();
		r.test();
	}
}
