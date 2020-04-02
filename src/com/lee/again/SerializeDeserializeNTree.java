package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SerializeDeserializeNTree {
	public static void main(String[] args) {
		SerializeDeserializeNTree obj = new SerializeDeserializeNTree();

		String s = "4(5)(6(7)(9))(10)";
		// String s ="45(12)";
		Node r = obj.deserialize(s);
		System.out.println(s);
		System.out.println(obj.serialize(r));
	}

	// Encodes a tree to a single string.
	public String serialize(Node root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		if (root.children != null) {
			for (Node n : root.children) {
				String s = serialize(n);
				sb.append("(").append(s).append(")");
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		System.out.println("....data " + data);
		Stack<Character> stack = new Stack<>();

		Node root = null;
		if (data.contains("(")) {
			String v = data.substring(0, data.indexOf("("));
			int val = Integer.valueOf(v);
			root = new Node(val, new ArrayList<Node>());
			int start = data.indexOf("(");
			for (int i = start; i < data.length(); i++) {
				if (data.charAt(i) == '(') {
					stack.push('(');
				} else if (data.charAt(i) == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(')');
					}
				}
				if (stack.isEmpty()) {
					Node c = deserialize(data.substring(start + 1, i));
					root.children.add(c);
					start = i + 1;
				}
				
			}
		} else {
			int val = Integer.valueOf(data);
			root = new Node(val, new ArrayList<Node>());
		}

		return root;

	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
