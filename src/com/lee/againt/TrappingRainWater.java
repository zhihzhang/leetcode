package com.lee.againt;

public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater obj = new TrappingRainWater();
		System.out.println(obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

	}
	
	//[0,1,0,2,1,0,1,3,2,1,2,1]
	
	public int trap(int[] height) {
		int sum = 0;
		int h = 0;
		int temp = 0;
		int leftIndex = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] >= h) {
				h = height[i];
				sum += temp;
				temp = 0;
				leftIndex = i;
			} else {
				temp += (h - height[i]);
			}
		}
		
		h = 0;
		temp = 0;
		for (int i = height.length - 1; i >= leftIndex; i--) {
			if (height[i] >= h) {
				h = height[i];
				sum += temp;
				temp = 0;
			} else {
				temp += (h - height[i]);
			}
		}
		return sum;
	}

}
