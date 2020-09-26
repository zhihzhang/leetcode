package com.lee.aafour;

import com.lee.common.ListNode;

public class IntersectionTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode a = headA;
		ListNode b = headB;
		if(a==null || b==null){
			return null;
		}
		while (headA != headB) {
			if (headA == null) {
				headA = b;
			} else {
				headA = headA.next;
			}
			
			if (headB == null) {
				headB = a;
			} else {
				headB = headB.next;
			}
		}
		return headA;
	}

}
