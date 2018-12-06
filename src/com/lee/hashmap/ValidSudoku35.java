package com.lee.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidSudoku35 {
	public static void main(String[] args) {
		ValidSudoku35 obj = new ValidSudoku35();
//		{
//		char[][] board = new char[][]{
//			  {'8','3','.','.','7','.','.','.','.'},
//			  {'6','.','.','1','9','5','.','.','.'},
//			  {'.','9','8','.','.','.','.','6','.'},
//			  {'8','.','.','.','6','.','.','.','3'},
//			  {'4','.','.','8','.','3','.','.','1'},
//			  {'7','.','.','.','2','.','.','.','6'},
//			  {'.','6','.','.','.','.','2','8','.'},
//			  {'.','.','.','4','1','9','.','.','5'},
//			  {'.','.','.','.','8','.','.','7','9'}
//		};
//		System.out.println(obj.isValidSudoku(board));
//		}
		{
			char[][] board = new char[][]{
				 {'.','.','5','.','.','.','.','.','.'},
				 {'1','.','.','2','.','.','.','.','.'},
				 {'.','.','6','.','.','3','.','.','.'},
				 {'8','.','.','.','.','.','.','.','.'},
				 {'3','.','1','5','2','.','.','.','.'},
				 {'.','.','.','.','.','.','.','4','.'},
				 {'.','.','6','.','.','.','.','.','.'},
				 {'.','.','.','.','.','.','.','9','.'},
				 {'.','.','.','.','.','.','.','.','.'}
			};
			System.out.println(obj.isValidSudoku(board));
		}

	}

	public boolean isValidSudoku(char[][] board) {
		Map<Integer, Set<Character>> rowMap = new HashMap<Integer, Set<Character>>();
		Map<Integer, Set<Character>> columnMap = new HashMap<Integer, Set<Character>>();

		int[][] indexes = new int[][] { { 0, 0 }, { 0, 3 }, { 0, 6 }, { 3, 0 }, { 3, 3 }, { 3, 6 }, { 6, 0 }, { 6, 3 },
				{ 6, 6 } };
				

		for (int[] index : indexes) {
			int a = index[0];
			int b = index[1];
			System.out.println("###......a:"+a +"  b:"+b );
			Set<Character> set = new HashSet<Character>();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					char c = board[a + i][b + j];
					System.out.println("...i:"+(a+i) + " j:"+(b+j) + "  " + c);
					if (c == '.') {
						continue;
					}
					Set<Character> rowSet = rowMap.get(a+i);
					if (rowSet == null) {
						rowSet = new HashSet<Character>();
						rowSet.add(c);
						rowMap.put(a + i, rowSet);
					} else {
						if (rowSet.contains(c)) {
							System.out.println("...row ");
							return false;
						}else{
							rowSet.add(c);
						}
					}
					
					if(b+j==2){
						System.out.println("....");
					}

					Set<Character> columnSet = columnMap.get(b+j);
					if (columnSet == null) {
						columnSet = new HashSet<Character>();
						columnSet.add(c);
						columnMap.put(b + j, columnSet);
					} else {
						if (columnSet.contains(c)) {
							System.out.println("...column");
							return false;
						}else{
							columnSet.add(c);
						}
					}

					if (set.contains(c)) {
						System.out.println("...grid");
						return false;
					} else {
						set.add(c);
					}

				}
			}
		}
		
		

		return true;
	}

}
