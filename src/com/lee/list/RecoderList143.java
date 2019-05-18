package com.lee.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lee.common.ListNode;

public class RecoderList143 {

	public static void main(String[] args) {
		RecoderList143 obj = new RecoderList143();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		obj.reorderList(n1);
		
		while(n1!=null){
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}
	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		Map<ListNode, ListNode> map = new HashMap<>();

		ListNode node = head;
		int count = 1;
		while (node.next != null) {
			map.put(node.next, node);
			node = node.next;
			count++;
		}

		ListNode t = null;
		ListNode h = head;
		while (h != null && count > 2) {
			t = h.next;
			node.next = t;
			h.next = node;
			h = t;
			node = map.get(node);
			node.next = null;
			count = count - 2;
		}
	}

}
