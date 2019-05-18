package com.lee.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {

	public static void main(String[] args) {
		CloneGraph obj = new CloneGraph();

	}
	
    public Node cloneGraph(Node node) {
		Map<Node, Node> map = new HashMap<>();

		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			Node t = new Node(n.val, new ArrayList<Node>());
			map.put(n, t);
			for (Node c : n.neighbors) {
				if (!map.containsKey(c)) {
					queue.offer(c);
				}
			}
		}
		
		queue.offer(node);
		Set<Node> set = new HashSet<Node>();
		set.add(node);
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			Node t = map.get(n);
			for (Node c : n.neighbors) {
				t.neighbors.add(map.get(c));
				if(!set.contains(c)){
					queue.offer(c);
					set.add(c);
				}
			}
		}
		return map.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
}
