package com.lee.againt;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> r = new ArrayList<>();
		int left = 0;
		int right = arr.length - 1;
		while (left + k <= right) {
			if (x - arr[left] > arr[right] - x) {
				left++;
			} else {
				right++;
			}
		}
		for (int i = left; i <= right; i++) {
			r.add(arr[i]);
		}
		return r;
	}

}
