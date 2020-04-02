package com.lee.againt;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		CanPlaceFlowers obj = new CanPlaceFlowers();
		int[] nums = new int[]{1,0,0,1};
		System.out.println(obj.canPlaceFlowers(nums, 1));
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		if (flowerbed == null || flowerbed.length == 0) {
			return count >= n;
		}
		if (flowerbed[0] == 0 && flowerbed.length == 1) {
			return 1 >= n;
		}
		if (flowerbed[0] == 0 && flowerbed[1] == 0) {
			flowerbed[0] = 1;
			count++;
		}
		for (int i = 1; i < flowerbed.length; i++) {
			if (i == flowerbed.length - 1) {
				if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
					count++;
				}
			} else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
				count++;
				flowerbed[i] = 1;
			}
			if (count >= n) {
				return true;
			}
		}
		return false;
	}

}
