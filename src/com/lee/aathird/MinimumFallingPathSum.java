package com.lee.aathird;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minFallingPathSum(int[][] A) {
		int n = A.length;
		int[][] dp = new int[n][n];
        int min1 = Integer.MAX_VALUE;
		for(int j=0;j<n;j++){
			dp[0][j] = A[0][j];
            min1 = Math.min(min1, dp[0][j]);
		}
		int min = Integer.MAX_VALUE;
		for(int i=1;i<n;i++){
			for(int j=0;j<n;j++){
				if(j==0){
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + A[i][j];
				}else if (j==n-1){
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + A[i][j];
				}else{
					int t = Math.min(dp[i-1][j], dp[i-1][j+1]);
					dp[i][j] = Math.min(t, dp[i-1][j-1]) + A[i][j];
				}
				if(i==n-1){
					min = Math.min(min, dp[i][j]);
				}
			}
		}
		if(min==Integer.MAX_VALUE){
            return min1;
        }
        return min;
	}

}
