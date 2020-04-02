package com.lee.againt;

public class SerializeDeserializeBinaryTree {

	public static void main(String[] args) {
		SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();
		TreeNode root = obj.deserialize("1 2 NULL NULL 3 4 NULL NULL 5 NULL NULL");
		String x = obj.serialize(root);
		System.out.println(x);

	}
	
//  1
// / \
//2   3
//   / \
//  4   5
	//  1 2 NULL NULL 3 4 NULL NULL 5 NULL NULL
	
	int index = 0;
	
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "NULL";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(root.val);
		sb.append(" ");
		sb.append(serialize(root.left));
		sb.append(" ");
		sb.append(serialize(root.right));
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] array = data.split(" ");
		TreeNode root = getNode(array);
		return root;
	}
    
    public TreeNode getNode(String[] array) {
    	String s = array[index++];
    	if(s.equals("NULL")){
    		return null;
    	}
    	int val = Integer.valueOf(s);
    	TreeNode node = new TreeNode(val);
    	node.left = getNode(array);
    	node.right = getNode(array);
    	return node;
	}
    

}
