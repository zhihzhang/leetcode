package com.lee.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence128 {

	public static void main(String[] args) {
		LongestConsecutiveSequence128 obj = new LongestConsecutiveSequence128();
		System.out.println(obj.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2, 0, -1 }));

	}

	class UnionFind {
		private int count = 0;
		private Map<Integer,Integer> parent = new HashMap<>();
		private Map<Integer,Integer> height = new HashMap<>();
		private Map<Integer,Integer> size = new HashMap<>();
		private int maxSize = 1;

		public UnionFind() {
		}
		
		public void init(int n){
			if(!parent.containsKey(n)){
			parent.put(n, n);
			height.put(n, 1);
			size.put(n, 1);
			count++;
			}
		}

		public int find(int p) {
			while (p != parent.get(p)) {
				int t = parent.get(p);
				parent.put(p, parent.get(t));
				p = parent.get(p);
//				parent[p] = parent[parent[p]]; // path compression by halving
//				p = parent[p];
			}
			return p;
		}

		public void union(int p, int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if (rootP == rootQ){
				return;
			}
			if(height.get(rootQ)>height.get(rootP)){
				parent.put(rootP, rootQ);
				size.put(rootQ, size.get(rootQ) + size.get(rootP));
				maxSize = Math.max(maxSize, size.get(rootQ));
			}else{
				parent.put(rootQ, rootP);
				size.put(rootP, size.get(rootQ) + size.get(rootP));
				maxSize = Math.max(maxSize, size.get(rootP));
				if(height.get(rootP)==height.get(rootQ)){
					height.put(rootP, height.get(rootP)+1);
				}
			}
//			if (height[rootQ] > height[rootP]) {
//				parent[rootP] = rootQ;
//				size[rootQ] += size[rootP];
//				maxSize = Math.max(size[rootQ], maxSize);
//			} else {
//				parent[rootQ] = rootP;
//				size[rootP] += size[rootQ];
//				maxSize = Math.max(size[rootP], maxSize);
//				if (height[rootP] == height[rootQ]) {
//					height[rootP]++;
//				}
//			}
			count--;
		}

		public int count() {
			return count;
		}

		public int getMaxSize() {
			return maxSize;
		}
	}

	public int longestConsecutive(int[] nums) {
		if(nums==null || nums.length==0){
			return 0;
		}
		int max = 0;
		Set<Integer> set = new HashSet<Integer>();
		UnionFind uf = new UnionFind();
		for (int n : nums) {
			max = Math.max(n, max);
			set.add(n);
			uf.init(n);
		}
		
		for (int n : nums) {
			if (set.contains(n - 1)) {
				uf.union(n, n - 1);
			}
			if (set.contains(n + 1)) {
				uf.union(n, n + 1);
			}
		}
		return uf.getMaxSize();
	}

}
