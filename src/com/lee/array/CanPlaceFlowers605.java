package com.lee.array;

public class CanPlaceFlowers605 {

	public static void main(String[] args) {
		CanPlaceFlowers605 obj = new CanPlaceFlowers605();
		int[] arr = new int[]{1,0,0,0,1};
		System.out.println(obj.canPlaceFlowers(arr, 1));

	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int[] nums = new int[flowerbed.length + 2];
		nums[0] = 0;
		int i = 0;
		while (i < flowerbed.length) {
			nums[i + 1] = flowerbed[i];
			i++;
		}
		nums[i + 1] = 0;
		int count = 0;
		for (int k = 1; k < nums.length - 1; k++) {
			if(nums[k]==0 && nums[k-1]==0 && nums[k+1]==0){
				count++;
				nums[k]=1;
			}
		}
		return (count>=n);
	}

}
