package com.lee.dfs;

import com.lee.common.TreeNode;

//三、二叉树的遍历
//遍历即将树的所有结点访问且仅访问一次。按照根节点位置的不同分为前序遍历，中序遍历，后序遍历。
//前序遍历：根节点->左子树->右子树
//中序遍历：左子树->根节点->右子树
//后序遍历：左子树->右子树->根节点

//https://blog.csdn.net/zlp1992/article/details/51406067
//https://blog.csdn.net/clam_clam/article/details/6845399
//http://robinsoncrusoe.iteye.com/blog/808526

// http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
// https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
public class MorrisTraversal {
	public static void morrisTraversal(TreeNode root) {
		TreeNode temp = null;
		TreeNode current = root;
		while (current != null) {
			if (current.left != null) {
				// connect threading for root
				temp = current.left;
				while (temp.right != null && temp.right != current) {
					temp = temp.right;
				}
				// the threading already exists
				if (temp.right == null) {
					// construct the threading
					temp.right = current;
					current = current.left;
				} else {
					temp.right = null;
					System.out.println(current.val);
					current = current.right;
				}
			} else {
				System.out.println(current.val);
				current = current.right;
			}
		}
	}
	
    public static void main(String args[]) 
    {
        /* Constructed binary tree is
               1
             /   \
            2      3
          /  \
        4     5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
          
        morrisTraversal(root);
    }
}
