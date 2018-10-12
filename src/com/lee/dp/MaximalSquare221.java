package com.lee.dp;

public class MaximalSquare221 {

	public static void main(String[] args) {
		MaximalSquare221 obj = new MaximalSquare221();
//		{
//			char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
//					{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
//			System.out.println(obj.maximalSquare(matrix));
//		}
		
		{
			char[][] matrix = new char[][] { 
					{ '1', '1', '1', '1'}, 
					{ '1', '1', '1', '1'},
					{ '1', '1', '1', '1'}, 
					{ '1', '1', '1', '1'} 
				};
			System.out.println(obj.maximalSquare(matrix));
		}
	}
	
    public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int max = 0;
		int[][] data = new int[matrix.length][matrix[0].length];
//		for (int i = 0; i < data.length; i++) {
//			for (int j = 0; j < data[0].length; j++) {
//				if (matrix[i][j] == '1') {
//					data[i][j] = 1;
//				}
//			}
//		}
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						data[i][j] = 1;
						max = Math.max(max, 1);
//						System.out.println("...." + i + "*" + j + "    if    " + data[i][j]);
					} else {
						int t1 = Math.min(data[i - 1][j - 1], data[i][j - 1]);
						int t2 = Math.min(t1, data[i-1][j]);
						data[i][j] = Math.max(t2+1,1);
//                        System.out.println("...." + i + "*" + j + " = " + data[i][j]);
						max = Math.max(data[i][j], max);
					}
					
//					else if (data[i - 1][j - 1] == data[i][j - 1] && data[i][j - 1] == data[i - 1][j]) {
//						data[i][j] = Math.max(data[i - 1][j] + 1, 1);
//                        System.out.println("...." + i + "*" + j + " = " + data[i][j]);
//						max = Math.max(data[i][j], max);
//					} else {
//						data[i][j] = 1;
//						System.out.println("...." + i + "*" + j + "    else   " + data[i][j]);
//					}
				}
			}
		}
		
        return max * max;
    }

}
