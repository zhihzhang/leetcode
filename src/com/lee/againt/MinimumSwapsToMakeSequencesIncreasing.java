package com.lee.againt;

public class MinimumSwapsToMakeSequencesIncreasing {

	public static void main(String[] args) {
		MinimumSwapsToMakeSequencesIncreasing obj = new MinimumSwapsToMakeSequencesIncreasing();
		int[] A= new int[]{0,3,5,8,9};
		int[] B= new int[]{2,1,4,6,9};
		System.out.println(obj.minSwap(A, B));
	}
	
//	 6 5
//	 4 8 

	public int minSwap(int[] A, int[] B) {
		int[] undp = new int[A.length];
		int[] dp = new int[A.length];
		undp[0] = 1;
		dp[1] = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1] && B[i] > B[i - 1] && A[i] > B[i - 1] && B[i] > A[i - 1]) {
				undp[i] = Math.min(undp[i - 1], dp[i - 1]) + 1;
				dp[i] = Math.min(undp[i - 1], dp[i - 1]);
			} else if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
				dp[i] = dp[i - 1];
				undp[i] = undp[i - 1] + 1;
			} else if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
				dp[i] = undp[i - 1];
				undp[i] = dp[i - 1] + 1;
			}
		}

		return Math.min(dp[A.length - 1], undp[A.length - 1]);
	}

}
