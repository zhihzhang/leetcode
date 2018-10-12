package com.lee.binarysearch;

public class Search2DMatrix74 {
	public static void main(String[] args) {
		Search2DMatrix74 obj = new Search2DMatrix74();
		System.out.println(obj.toString());
		obj = new Search2DMatrix74();
		System.out.println(obj.toString());
		
		
		
		
//		{
//			int[][] matrix = new int[][] { 
//				{ 1, 3, 5, 7 }, 
//				{ 10, 11, 16, 20 }, 
//				{ 23, 30, 34, 50 } };
//			boolean r = obj.searchMatrix(matrix, 50);
//			System.out.println("...r " + r);
//		}
//		{
//			int[][] matrix = new int[][] { 
//				{ 1, 3, 5, 7 }, 
//				{ 10, 11, 16, 20 }, 
//				{ 23, 30, 34, 50 } };
//			boolean r = obj.searchMatrix(matrix, 3);
//			System.out.println("...r " + r);
//		}
//		{
//			int[][] matrix = new int[][] { 
//				{ 1 }, 
//				{ 3 }
//			};
//			boolean r = obj.searchMatrix(matrix, 2);
//			System.out.println("...r " + r);
//		}
//		{
//			int[][] matrix = new int[][] { 
//				{ 1 ,3, 5}
//			};
//			boolean r = obj.searchMatrix(matrix, 5);
//			System.out.println("...r " + r);
//		}

	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length==0) {
			return false;
		}

		int xl = 0;
		int yl = 0;
		int yh = matrix.length - 1;
		int xh = matrix[0].length - 1;

		int x = xh / 2;
		int y = yh / 2;
		
        if(target<matrix[0][0]){
            return false;
        }
        
        if(target>matrix[yh][xh]){
            return false;
        }

		while (true) {
			System.out.println(" x:" + x + ", y:" + y + "..." + matrix[y][x] + "..xh " + xh + "  yh " + yh);
			if (matrix[y][x] == target) {
				return true;
			} else if (matrix[y][x] < target) {
				int tx = (xh + x) / 2;
				int ty = (yh + y) / 2;

				if (x == tx && y == ty) {
					return check(tx, ty, matrix, target);
				}
				xl = x;
				yl = y;
				x = tx;
				y = ty;
			} else {
				int tx = (xl + x) / 2;
				int ty = (yl + y) / 2;

				if (x == tx && y == ty) {
					return check(xl, yl, matrix, target);
				}
				
				xh = x;
				yh = y;
				x = tx;
				y = ty;
			}
		}
	}
    
	public boolean check(int x, int y, int[][] matrix, int target) {
		System.out.println(" " + x + " " + y + "..target");
		for (int i = x; i <= matrix[0].length-1; i++) {
			if (matrix[y][i] == target) {
				return true;
			}
		}
		if (y < matrix.length - 1) {
			for (int i = 0; i <= matrix[0].length-1; i++) {
				System.out.println(y + "....x " + i + "....");
				if (matrix[y+1][i] == target) {
					return true;
				}
			}
		}
		return false;
	}

}
