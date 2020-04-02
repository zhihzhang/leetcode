package com.lee.againt;

import com.lee.common.TreeNode;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNodes(TreeNode root) {
		if(root==null){
			return 0;
		}
		int leftX = getLeftDepth(root.left);
		int leftY = getLeftDepth(root.right);
		if (leftX == leftY) {
			int n = (int) Math.pow(2, new Double(leftX));
			return n + countNodes(root.right);
		} else {
			int n = (int) Math.pow(2, new Double(leftY));
			return n + countNodes(root.left);
		}
	}

	public int getLeftDepth(TreeNode node) {
		int count = 0;
		while (node != null) {
			count++;
			node = node.left;
		}
		return count;
	}

}
