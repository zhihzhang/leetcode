package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.lee.common.TreeNode;

public class SmallestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	Set<String> set = new HashSet<>();
//
//	public String smallestFromLeaf(TreeNode root) {
//		dfs(root, "");
//		String t = null;
//		for (String s : list) {
//			System.out.println(s);
//			if (t == null) {
//				t = s;
//			}
//			t = compare(t, s);
//		}
//		return t;
//	}
//
//	public String compare(String a, String b) {
//		if (b.length() < a.length()) {
//			String t = a;
//			a = b;
//			b = t;
//		}
//		for (int i = 0; i < a.length(); i++) {
//			char x = a.charAt(i);
//			char y = b.charAt(i);
//			if (x < y) {
//				return a;
//			} else if (y < x) {
//				return b;
//			}
//		}
//		return a;
//	}
//
//	public void dfs(TreeNode root, String pre) {
//		if(root==null){
//			return;
//		}
//		if(root.left==null && root.right==null){
//			StringBuilder sb = new StringBuilder(pre + (char)(root.val+'a'));
//			set.add(sb.reverse().toString());
//		}
//		dfs(root.left, pre + (char)(root.val+'a'));
//		dfs(root.right, pre + (char)(root.val+'a'));
//	}

}
