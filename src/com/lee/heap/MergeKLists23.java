package com.lee.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists23 {

	public static void main(String[] args) {
		MergeKLists23 obj = new MergeKLists23();

	}
	
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
    	ListNode head = new ListNode(-1);
    	ListNode cur = head;
		Queue<ListNode> queue = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node==null){
                continue;
            }
        	queue.add(node);
        }
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();

			cur.next = node;
			cur = cur.next;

			queue.remove(node);
			if (node.next != null) {
				queue.add(node.next);
			}
		}
		
		return head.next;
    }
    
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
