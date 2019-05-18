package com.lee.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindDuplicateSubtrees652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Set<TreeNode> set = new HashSet<>();
	
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        traverse(root, map, ans);
        return ans;
    }
    
	private void traverse(TreeNode node, Map<Integer, List<TreeNode>> map, List<TreeNode> ans) {
		if (node == null) {
			return;
		}
		if(map.containsKey(node.val)){
			List<TreeNode> list = map.get(node.val);
			for (TreeNode n : list) {
				if (compare(n, node)) {
					if(!set.contains(n)){
						ans.add(n);
						set.add(n);
					}
					
					break;
				}
			}
			list.add(node);
		}else{
			List<TreeNode> list = new ArrayList<>();
			list.add(node);
			map.put(node.val, list);
		}
		traverse(node.left, map, ans);
		traverse(node.right, map, ans);
	}
    
	private boolean compare(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		if (a.val != b.val) {
			return false;
		}
		return (compare(a.left, b.left) && compare(a.right, b.right));
	}

}
