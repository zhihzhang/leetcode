package com.lee.aathird;

import java.util.Arrays;

public class ConstructRectangle {

	public static void main(String[] args) {
		ConstructRectangle obj = new ConstructRectangle();
		System.out.println(Arrays.toString(obj.constructRectangle(2)));

	}

	public int[] constructRectangle(int area) {
		int w = (int) Math.sqrt(area);
		if(w*w==area){
			return new int[]{w,w};
		}
		for (long i = w; i <= area; i++) {
			for (long j = w + 1; j > 0 && i * j >= area; j--) {
				if (i * j == area) {
					return new int[] { (int)i, (int)j };
				}
			}
		}
		return null;
	}

}
