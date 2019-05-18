package com.lee.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {

	public static void main(String[] args) {
		SpiralMatrix54 obj = new SpiralMatrix54();
//		int[][] matrix = new int[][]{
//			{1, 2, 3, 4},
//			{5, 6, 7, 8},
//			{9, 10,11,12}
//		};
		
		int[][] matrix = new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		System.out.println(obj.spiralOrder(matrix).toString());
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return list;
		}
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length - 1;
		int n = matrix.length * matrix[0].length;
		while (true) {
			for (int i = left; i <= right; i++) {
				list.add(matrix[top][i]);
			}
			top++;
			if(list.size()>=n){
				break;
			}

			for (int i = top; i <= bottom; i++) {
				list.add(matrix[i][right]);
			}
			right--;
			if(list.size()>=n){
				break;
			}

			for (int i = right; i >= left; i--) {
				list.add(matrix[bottom][i]);
			}
			bottom--;
			if(list.size()>=n){
				break;
			}

			for (int i = bottom; i >= top; i--) {
				list.add(matrix[i][left]);
			}
			left++;
			if(list.size()>=n){
				break;
			}
		}
		
		return list;

	}

}
