package com.lee.tree;

public class DiameterofBinaryTree543 {

	public static void main(String[] args) {
		DiameterofBinaryTree543 obj = new DiameterofBinaryTree543();

	}
	
	int max = 0;
	
    public int diameterOfBinaryTree(TreeNode root) {
        return max - 1;
    }
    
    public int length(TreeNode root) {
        if(root==null){
        	return 0;
        }
        int l = length(root.left);
        int r = length(root.right);
        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
    }

}
