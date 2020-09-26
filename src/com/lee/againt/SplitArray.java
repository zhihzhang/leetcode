package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	[1,2,3,3,4,5]
//	[1,2,3,3,4,4,5,5]
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> pre = new HashMap<>();
		Map<Integer, Integer> post = new HashMap<>();
		for (int n : nums) {
			if (pre.getOrDefault(n, 0) < 0) {
				pre.put(n, pre.getOrDefault(n, 0) + 1);
			} else if (post.getOrDefault(n, 0) < 0) {
				post.put(n, post.getOrDefault(n, 0) + 1);
				post.put(n + 1, post.getOrDefault(n + 1, 0) - 1);
			} else {
				pre.put(n + 1, pre.getOrDefault(n + 1, 0) - 1);
				pre.put(n + 2, pre.getOrDefault(n + 2, 0) - 1);
				post.put(n + 3, post.getOrDefault(n + 3, 0) - 1);
			}
		}
		for (int n : pre.values()) {
			if (n < 0) {
				return false;
			}
		}
		return true;
	}

}
