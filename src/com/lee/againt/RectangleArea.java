package com.lee.againt;

public class RectangleArea {

	public static void main(String[] args) {
		RectangleArea obj = new RectangleArea();
//		A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
	}

	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area1 = (C - A) * (D - B);  //24
		int area2 = (G - E) * (H - F);  //27
		//51

		int highBottom = Math.max(B, F);  // 0
		int lowCeiling = Math.min(D, H);  // 2

		int left = Math.max(A, E);   //0
		int right = Math.min(C, G);  //3

		int sum = area1 + area2;
		if (lowCeiling > highBottom && right > left) {
			sum -= (lowCeiling - highBottom) * (right - left);
		}
		return sum;
	}

}
