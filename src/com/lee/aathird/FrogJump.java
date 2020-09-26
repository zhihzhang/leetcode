package com.lee.aathird;

public class FrogJump {

	public static void main(String[] args) {
		FrogJump obj = new FrogJump();
		System.out.println(obj.canCross(new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }));
		System.out.println(obj.canCross(new int[] { 0, 1, 2, 3, 4, 8, 9, 11 }));
	}

	int[][] cache;

	public boolean canCross(int[] stones) {
		cache = new int[stones.length][stones.length];
		return jump(stones, 0, 0);
	}

	public boolean jump(int[] stones, int start, int pre) {
		if (start == stones.length - 1) {
			return true;
		}
		if (cache[start][pre] == -1) {
			return false;
		}
		int t = stones[start];
		for (int i = start + 1; i < stones.length; i++) {
			if (stones[i] == t + pre - 1 || stones[i] == t + pre || stones[i] == t + pre + 1) {
				if (jump(stones, i, stones[i] - t)) {
					return true;
				}
			}
			if (stones[i] > t + pre + 1) {
				break;
			}
		}
		cache[start][pre] = -1;
		return false;
	}

}
