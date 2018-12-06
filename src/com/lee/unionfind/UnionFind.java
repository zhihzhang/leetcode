package com.lee.unionfind;

public class UnionFind {

	// https://blog.csdn.net/dm_vincent/article/details/7655764
	// https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
	public static void main(String[] args) {

	}

	private int[] id; // access to component id (site indexed)
	private int count; // number of components
	private int[] sz;

	public UnionFind(int N) {
		// Initialize component id array.
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		for (int i = 0; i < N; i++) {
			sz[i] = 1; // 初始情况下，每个组的大小都是1
		}
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private int find(int p) {
		while (p != id[p]) {
			// 将p节点的父节点设置为它的爷爷节点
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}
		// 将小树作为大树的子树
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

}
