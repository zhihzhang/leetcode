package com.lee.twopointers;

public class PartitionList88 {

	public static void main(String[] args) {
		PartitionList88 obj = new PartitionList88();
		ListNode head = obj.init(new int[] { 1, 4, 3, 2, 5, 2 });
		ListNode start = obj.partition(head, 3);
		int count = 0;
		while (start != null) {
			System.out.print(start.val + "  ");
			start = start.next;
			count++;
			if(count>10){
				break;
			}
		}
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode a = new ListNode(123);
		ListNode aHead = a;
		ListNode b = new ListNode(123);
		ListNode bHead = b;
		while (head != null) {
			if (head.val < x) {
				a.next = head;
				a = a.next;
			} else {
				b.next = head;
				b = b.next;
			}
			head = head.next;
		}
		b.next = null;
		a.next = bHead.next;
		return aHead.next;

	}

	public ListNode init(int[] nums) {
		ListNode head = new ListNode(nums[0]);
		ListNode current = head;
		for (int i = 1; i < nums.length; i++) {
			ListNode node = new ListNode(nums[i]);
			current.next = node;
			current = node;
		}
		// current.next = head;
		return head;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
