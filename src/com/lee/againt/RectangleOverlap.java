package com.lee.againt;

public class RectangleOverlap {

	public static void main(String[] args) {
		RectangleOverlap obj = new RectangleOverlap();
		int[] rec1 = new int[]{5,15,8,18};
		int[] rec2 = new int[]{0,3,7,9};
		obj.isRectangleOverlap(rec1, rec2);
	}

	// A rectangle is represented as a list [x1, y1, x2, y2],
	// where (x1, y1) are the coordinates of its bottom-left corner,
	// and (x2, y2) are the coordinates of its top-right corner.
	
	
//	[5,15,8,18]
//	[0,3,7,9]
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		int highBottom = Math.max(rec1[1], rec2[1]);  //15
		int lowTop = Math.min(rec1[3], rec2[3]);   //9

		int left = Math.max(rec1[0], rec2[0]);   //5
		int right = Math.min(rec1[2], rec2[2]);   //7
		if (lowTop > highBottom && right > left) {
			return true;
		}
		return false;
	}

}
