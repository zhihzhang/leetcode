package com.lee.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lee.common.TreeNode;

public class BinaryTreeZigzag103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> sol = new ArrayList<>();
        sol = levelOrder(root);
        return sol;
    }
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> resultList = new ArrayList<>();
		int levelNum = 0;
		Queue<TreeNode> treeQueue = new LinkedList<>();
		treeQueue.add(root);
		int level = 1;
		while (!treeQueue.isEmpty()) {
			levelNum = treeQueue.size();
			List<Integer> levelList = new ArrayList<>();
			while (levelNum > 0) {
				TreeNode tempNode = treeQueue.poll();
				if (tempNode != null) {
					levelList.add(tempNode.val);

					treeQueue.add(tempNode.left);
					treeQueue.add(tempNode.right);
				}
				levelNum--;
			}
			if (level % 2 == 0) {
				Collections.reverse(levelList);
			}
			level++;
			if (levelList.size() > 0)
				resultList.add(levelList);
		}
		return resultList;
	}
}
