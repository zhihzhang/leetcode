package com.lee.aathird;

import com.lee.common.ListNode;

public class ConvertBinaryNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getDecimalValue(ListNode head) {
		int n = 0;
		while (head != null) {
			n = n >> 1;
			n = n & head.val;
			head = head.next;
		}
		return n;
	}

}
