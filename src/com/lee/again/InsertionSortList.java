package com.lee.again;

import com.lee.common.ListNode;

public class InsertionSortList {

	public static void main(String[] args) {
		InsertionSortList obj = new InsertionSortList();
		ListNode a = new ListNode(Integer.MIN_VALUE+1);
		ListNode b = new ListNode(Integer.MIN_VALUE);
//		ListNode c = new ListNode(1);
//		ListNode d = new ListNode(3);
		a.next = b;
		b.next = null;
//		c.next = d;
		ListNode m = obj.insertionSortList(a);
		while(m!=null){
			System.out.println(m.val);
			m = m.next;
		}
	}
	
	// 4 2 1 3
	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode mock = new ListNode(Integer.MIN_VALUE);
		mock.next = head;

		ListNode node = head.next;
		// ListNode next = null;
		ListNode pre = head;
		while (node != null) {
			ListNode h = mock;
			boolean flag = false;
			while (h != null && h != node) {
				// if (h == node) {
				// pre = node;
				// node = node.next;
				// flag = true;
				// break;
				// }
				if (h.val <= node.val && node.val < h.next.val) {
					pre.next = node.next;
					node.next = h.next;
					h.next = node;
					node = pre.next;
					flag = true;
					break;
				}
				h = h.next;
			}
			if (flag) {
				continue;
			}
			pre = node;
			node = node.next;
		}
    	
    	
    	return mock.next;
    }

}
