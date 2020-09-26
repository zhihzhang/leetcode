package com.lee.aathird;

import com.lee.common.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1->2->3->4->5->NULL
    // 5->4->3->2->1->NULL
    public ListNode reverseList(ListNode head) {
    	if(head==null || head.next==null){
    		return head;
    	}
    	ListNode fast = head.next;
    	ListNode slow = head;
    	ListNode mock = null;
    	while(fast!=null){
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
