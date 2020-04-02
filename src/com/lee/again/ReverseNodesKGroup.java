package com.lee.again;

import com.lee.common.ListNode;

public class ReverseNodesKGroup {

	public static void main(String[] args) {
		ReverseNodesKGroup obj = new ReverseNodesKGroup();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		ListNode t = obj.reverseKGroup(a, 3);
		while(t!=null){
			System.out.println(t.val);
			t=t.next;
		}
		
	}

	// 1->2->3->4->5->6->7
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k==1 || head==null || head.next==null){
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode h = new ListNode(-1);
		h.next = head;
		ListNode slow = null;
		ListNode fast = head;
		

		boolean flag = true;
		while (flag) {
			ListNode x = fast;
			for (int i = 0; i < k; i++) {
				if(x==null){
					flag = false;
					break;
				}
				x = x.next;
			}
			if(!flag){
				break;
			}
			for (int i = 0; i < k; i++) {
				ListNode t = fast.next;
				fast.next = slow;
				slow = fast;
				fast = t;
//				if (t == null) {
//					flag = false;
//					break;
//				}
			}
			ListNode t = h.next;
			h.next = slow;
			t.next = fast;
			if (dummy.val == -1) {
				dummy.next = slow;
				dummy.val = 1;
			}
			h = t;
			slow = t;
		}

		return dummy.next;
	}

	public ListNode reverseKGroupA(ListNode head, int k) {
		if(k==1 || head==null || head.next==null){
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode h = new ListNode(-1);
		h.next = head;
		ListNode slow = null;
		ListNode fast = head;
		

		boolean flag = true;
		while (flag) {
			for (int i = 0; i < k; i++) {
				ListNode t = fast.next;
				fast.next = slow;
				slow = fast;
				fast = t;
				if (t == null) {
					flag = false;
					break;
				}
			}
			ListNode t = h.next;
			h.next = slow;
			t.next = fast;
			if (dummy.val == -1) {
				dummy.next = slow;
				dummy.val = 1;
			}
			h = t;
			slow = t;
		}

		return dummy.next;
	}

}
