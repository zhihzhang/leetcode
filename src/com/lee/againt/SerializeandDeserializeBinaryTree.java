package com.lee.againt;

import java.util.Stack;

public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {
		SerializeandDeserializeBinaryTree obj = new SerializeandDeserializeBinaryTree();
		TreeNode root = obj.deserialize("2 4 null null 5 null null");
		String s = obj.serialize(root);
		System.out.println(s);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "null";
		}
		return root.val + " " + serialize(root.left) + " " + serialize(root.right);
	}

	int index = 0;

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("null")) {
			return null;
		}
		String[] array = data.split(" ");
		return getNode(array);
	}

	public TreeNode getNode(String[] array) {
		if (array[index].equals("null")) {
			index++;
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(array[index]));
		index++;
		root.left = getNode(array);
		root.right = getNode(array);
		return root;
	}

}
