package com.lee.twopointers;

//Input:
//[1,3,2,5,25,24,5]
//Output:
//15
//Expected:
//24
public class MostWater {

	public static void main(String[] args) {
		MostWater obj = new MostWater();
		int[] a = { 1, 3, 2, 5, 25, 24, 5 };
		int max = obj.maxArea(a);
		System.out.println(max);
	}

	public int maxArea(int[] height) {
		int startIndex = 0;
		int endIndex = height.length - 1;
		int max = getArea(0, height.length - 1, height);

		while (startIndex < endIndex) {
			System.out.println("....start " + startIndex + "    end " + endIndex);
			if (height[startIndex] < height[endIndex]) {
				startIndex++;
			} else {
				endIndex--;
			}
			int area = getArea(startIndex, endIndex, height);
			max = Math.max(area, max);
//			int leftArea = getArea(startIndex + 1, endIndex, height);
//			int rightArea = getArea(startIndex, endIndex - 1, height);
//			if (leftArea >= rightArea) {
//				startIndex++;
//				max = Math.max(max, leftArea);
//			} else {
//				endIndex--;
//				max = Math.max(max, rightArea);
//			}
		}
		return max;
	}

	public int getArea(int start, int end, int[] height) {
		if (end <= start) {
			return 0;
		}
		int bar = Math.min(height[start], height[end]);
		int area = bar * (end - start);
		return area;
	}

}
