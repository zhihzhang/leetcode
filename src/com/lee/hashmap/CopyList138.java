package com.lee.hashmap;

import java.util.HashMap;
import java.util.Map;

public class CopyList138 {

	public static void main(String[] args) {
		CopyList138 obj = new CopyList138();

	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return head;
		}

		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode v = new RandomListNode(cur.label);
			map.put(cur, v);
			cur = cur.next;
		}

		cur = head;
		while (cur != null) {
			RandomListNode v = map.get(cur);
			if (cur.next != null) {
				v.next = map.get(cur.next);
			}
			if (cur.random != null) {
				v.random = map.get(cur.random);
			}
			cur = cur.next;
		}
		return map.get(head);
	}

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

}
