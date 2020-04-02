package com.lee.again;

public class FriendCircles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int count = 0;
	
	public void dfs(int[][] M, int i, int j, int n, int m){
		M[i][j]=-1;
		if (i + 1 < n && M[i + 1][j] == 1) {
			dfs(M, i + 1, j, n, m);
		}
		if (i - 1 >=0 && M[i - 1][j] == 1) {
			dfs(M, i - 1, j, n, m);
		}
		if (j + 1 < m && M[i][j+1] == 1) {
			dfs(M, i, j + 1, n, m);
		}
		if (j - 1 >= 0 && M[i][j-1] == 1) {
			dfs(M, i, j-1, n, m);
		}
		
	}
	
	
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		if(M[i][j]==1){
        			count++;
        			dfs(M, i, j, n, m);
        		}
        	}
        }
        
        return count;
    }

}
