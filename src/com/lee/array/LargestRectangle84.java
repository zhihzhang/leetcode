package com.lee.array;

public class LargestRectangle84 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangle84 obj = new LargestRectangle84();
		System.out.println(obj.largestRectangleArea(new int[]{0,9}));

	}

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		if (heights.length == 1) {
			return heights[0];
		}

		int max = 0;
		int min = 0;
		for (int i = 0; i < heights.length; i++) {
			min = heights[i];
			for (int j = i; j < heights.length; j++) {
				if (heights[j] == 0) {
					break;
				}
				min = Math.min(heights[j], min);
				int t = (j - i + 1) * min;
				max = Math.max(t, max);
			}
		}
		return max;
	}

}
