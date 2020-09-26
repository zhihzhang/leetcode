package com.lee.aafour;

public class NumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] sums;
	int[] arr; 
	
	public NumArray(int[] nums) {
		arr = nums;
		sums = new int[nums.length];
		int sum = 0;
		int i = 0;
		for (int n : nums) {
			sum += n;
			sums[i++] = sum;
		}
	}
    
	public void update(int i, int val) {
		for (int j = i; j < sums.length; j++) {
			sums[j] = sums[j] - arr[i] + val;
		}
		arr[i] = val;
	}
    
    public int sumRange(int i, int j) {
        int t = sums[j] - sums[i] + arr[i];
        return t;
    }

}
