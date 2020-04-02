package com.lee.againt;

import java.util.ArrayList;
import java.util.List;

import com.lee.tree.MaximumWidthTree662;

public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix obj = new SpiralMatrix();
		int[][] a = new int[][] { 
			{ 1, 2, 3, 4 }, 
			{ 5, 6, 7, 8 }, 
			{ 9, 10, 11, 12 }, 
			{ 13, 14, 15, 16 } };
		int[][] b = new int[][] { 
			{ 1, 2, 3 }, 
			{ 4, 5, 6 }, 
			{ 7, 8, 9 } };
		int[][] c = new int[][] { 
			{ 1, 2, 3, 4 }, 
			{ 5, 6, 7, 8 }, 
			{ 9, 10, 11, 12 } };
		int[][] d = new int[][] { 
			{ 1, 2, 3 }, 
			{ 4, 5, 6 }, 
			{ 7, 8, 9 },
			{ 10,11,12}};
		System.out.println(obj.spiralOrder(a));
		System.out.println(obj.spiralOrder(b));
		System.out.println(obj.spiralOrder(c));
		System.out.println(obj.spiralOrder(d));

	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return list;
		}
		int l = 0;
		int r = matrix[0].length - 1;
		int h = 0;
		int t = matrix.length - 1;
		while (l <= r && h <= t) {
			for (int i = l; i <= r; i++) {
				list.add(matrix[h][i]);
			}
			for (int i = h + 1; i <= t; i++) {
				list.add(matrix[i][r]);
			}
			for (int i = r - 1; i >= l && t!=h; i--) {
				list.add(matrix[t][i]);
			}
			for (int i = t - 1; i > h && l!=r; i--) {
				list.add(matrix[i][l]);
			}
			l++;
			r--;
			h++;
			t--;
		}
		return list;
	}

}
