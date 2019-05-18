package com.lee.again;

import com.lee.common.ListNode;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		ReverseLinkedListII obj = new ReverseLinkedListII();

	}

//	Input: 1->2->3->4->5->NULL, m = 2, n = 4
//			Output: 1->4->3->2->5->NULL
	
	//   [3,5]  1,2
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head.next == null || (m == n)) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		ListNode h = dummy;
		dummy.next = head;
		for (int i = 0; i < m - 1; i++) {
			dummy = dummy.next;
		}
		ListNode slow = dummy.next;
		ListNode fast = slow.next;
		ListNode t = null;
		for (int i = 0; i < (n-m); i++) {
			t = fast.next;
			fast.next = slow;
			slow = fast;
			fast = t;
		}
		
		dummy.next.next = t;
        dummy.next = slow;
        
		return h.next;
	}

}
