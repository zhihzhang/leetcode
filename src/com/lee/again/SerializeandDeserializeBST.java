package com.lee.again;

import java.util.Arrays;
import java.util.Collections;

import com.lee.common.TreeNode;

public class SerializeandDeserializeBST {

	public static void main(String[] args) {
		// String x = "123456789";
		// System.out.println(x.substring(1, 5));
		// System.out.println(x.substring(5));

		SerializeandDeserializeBST obj = new SerializeandDeserializeBST();
		TreeNode root = obj.deserialize("2,1");
		String s = obj.serialize(root);
		System.out.println(s);

	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		String left = serialize(root.left);
		String right = serialize(root.right);
		StringBuilder sb = new StringBuilder();
		sb.append(root.val + "");
		if (left.length() > 0) {
			sb.append(",").append(left);
		}
		if (right.length() > 0) {
			sb.append(",").append(right);
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		String[] array = data.split(",");
		return deserializeWithArray(array, 0, array.length);
	}

	public TreeNode deserializeWithArray(String[] data, int l, int h) {
		if (data == null || data.length == 0 || l >= h) {
			return null;
		}
		int v = Integer.valueOf(data[l]);
		TreeNode root = new TreeNode(v);
		for (int i = l + 1; i < h; i++) {
			int t = Integer.valueOf(data[i]);
			if (t >= v) {
				root.left = deserializeWithArray(data, l + 1, i);
				root.right = deserializeWithArray(data, i, h);
				return root;
			}
		}
		root.left = deserializeWithArray(data, l + 1, h);
		root.right = null;
		return root;
	}

}
