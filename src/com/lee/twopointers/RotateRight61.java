package com.lee.twopointers;


public class RotateRight61 {

	public static void main(String[] args) {
		RotateRight61 obj = new RotateRight61();
		ListNode head = obj.init(new int[] { 0, 1});
		ListNode start = obj.rotateRight(head, 2);
		while (start != null) {
			 System.out.print(start.val);
			start = start.next;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		if (k == 0 || head.next == null) {
			return head;
		}
		ListNode mock = new ListNode(-1);
		mock.next = head;
		ListNode fast = mock;
		ListNode slow = mock;
		int count = 0;
		boolean isEnd = false;
		while (true) {
			if (fast.next == null) {
				if (isEnd) {
					fast.next = head;
					ListNode temp = slow.next;
					slow.next = null;
					return temp;
				} else {
					k = k % count;
					fast = mock;
					count = 0;
					continue;
				}
			}
			fast = fast.next;
			count++;
//			if (count == k) {
//				finishFirstRound = true;
//			}
			if (count > k) {
				isEnd = true;
				slow = slow.next;
			}
		}

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
