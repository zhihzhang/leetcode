package com.lee.twopointers;

public class Cycle142 {
	/*
	n is count of cicle;
	a is steps before circle;
	b is steps in circle
	a + b = steps;
	a + c*n + b = steps * 2;
	a + c*n + b = a*2 + 2*b;
	c*n = a + b;
	c*n = steps;
	*/

	public static void main(String[] args) {
		Cycle142 obj = new Cycle142();
		ListNode head = obj.init(new int[] { 1, 2, 3, 4, 5, 6, 7, 8});
		ListNode fast = head;
		ListNode slow = head;
		int steps = 0;
		do {
			slow = slow.next;
			fast = fast.next.next;
			steps++;
			System.out.println(steps + "...fast " + fast.val + "   slow " + slow.val);
		} while (slow.val != fast.val);
		System.out.println(steps);
	}
	
	/*
	 fast and slow step to same point a+b;
	 when slow2 and slow go steps and they will go to at the same point fast and slow meet
	 slow2 go a and slow spin c*n - b;
	 */
	
//	public class Solution {
//        public ListNode detectCycle(ListNode head) {
//            ListNode slow = head;
//            ListNode fast = head;
//    
//            while (fast!=null && fast.next!=null){
//                fast = fast.next.next;
//                slow = slow.next;
//                
//                if (fast == slow){
//                    ListNode slow2 = head; 
//                    while (slow2 != slow){
//                        slow = slow.next;
//                        slow2 = slow2.next;
//                    }
//                    return slow;
//                }
//            }
//            return null;
//        }
//    }

	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		int setps = 0;
		do {
			if(fast.next == null || fast.next.next == null){
				return null; // no circle
			}
			slow = slow.next;
			fast = fast.next.next;
			setps++;
		} while (slow.val != fast.val);

		ListNode first = slow;

		int cycleCount = 0;
		do {
			slow = slow.next;
			fast = fast.next.next;
			cycleCount++;
		} while (slow.val != fast.val);

		return head;

	}

	public ListNode init(int[] nums) {
		ListNode head = new ListNode(nums[0]);
		ListNode current = head;
		for (int i = 1; i < nums.length; i++) {
			ListNode node = new ListNode(nums[i]);
			current.next = node;
			current = node;
		}
		current.next = head;
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
