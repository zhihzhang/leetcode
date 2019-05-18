package com.lee;

import com.lee.common.ListNode;

public class SwapNodes24 {

	public static void main(String[] args) {
		SwapNodes24 obj = new SwapNodes24();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		ListNode head = obj.swapPairs(a);
		System.out.println(head.val);
		while(head.next!=null){
			System.out.println(head.next.val);
			head = head.next;
		}
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode node = head;
		boolean isFirst = true;
		ListNode pre = null;
		while(true){
			if(node==null || node.next==null){
				break;
			}
			ListNode t = swap(node);
			if(isFirst){
				head = t;
				isFirst = false;
			}
			if(pre!=null){
				pre.next = t;
			}
			pre = t.next;
			node = t.next.next;
			if (node != null) {
				System.out.println(node.val);
			}
		}
		return head;
	}
    
	public ListNode swap(ListNode node) {
		ListNode first = node;
		ListNode second = node.next;
		ListNode third = second.next;
		second.next = first;
		first.next = third;
		return second;
	}

}
