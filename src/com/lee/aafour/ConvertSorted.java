package com.lee.aafour;

import com.lee.common.ListNode;
import com.lee.common.TreeNode;

public class ConvertSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode t = head;
		ListNode fast = head;
		ListNode slow = head;
		boolean f = false;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (!f) {
				f = true;
			} else {
				t = t.next;
			}
		}

		TreeNode root = new TreeNode(slow.val);
		TreeNode right = sortedListToBST(slow.next);
		t.next = null;
		TreeNode left = sortedListToBST(head);
		root.left = left;
		root.right = right;
		return root;
	}

}
