package com.lee.again;

import com.lee.common.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//1->2->2->1
	//1->2->3->2->1

	public boolean isPalindrome(ListNode head) {
		int l = 0;
		ListNode mock = head;
		while (mock != null) {
			l++;
			mock = mock.next;
		}
		if(l<2){
			return true;
		}
		int half = l / 2;
		mock = head;
		for (int i = 0; i < half; i++) {
			mock = mock.next;
		}
		ListNode tail = reverse(mock);
		for (int i = 0; i < half; i++) {
			if (head.val != tail.val) {
				return false;
			}
			head = head.next;
			tail = tail.next;
		}
		return true;
	}

	public ListNode reverse(ListNode head) {
		ListNode fast = head.next;
		ListNode slow = head;
		ListNode mock = null;
		while (fast != null) {
			ListNode t = fast.next;
			fast.next = slow;
			slow.next = mock;

			mock = slow;
			slow = fast;
			fast = t;
		}
		return slow;
	}

}
