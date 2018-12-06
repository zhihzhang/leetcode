package com.lee.backtrace;

import java.util.ArrayList;
import java.util.List;

public class WordSearch79 {
	public static void main(String[] args) {
		WordSearch79 obj = new WordSearch79();
		char[][] board = new char[][] { 
			{ 'A', 'B', 'C', 'E' }, 
			{ 'S', 'F', 'C', 'S' }, 
			{ 'A', 'D', 'E', 'E' } 
			};
//			StringBuilder sb = new StringBuilder("AB");
//			sb = new StringBuilder(sb.subSequence(0, sb.length() - 1));
//			System.out.println(sb.toString());
			
			
			
//		 System.out.println(obj.exist(board, "ABCCED"));
//		 System.out.println(obj.exist(board, "SEE"));
		System.out.println(obj.exist(board, "ABCB"));
	}

	int[][] d = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public boolean exist(char[][] board, String word) {
//		StringBuilder sb1 = new StringBuilder();
		List<Character> list = new ArrayList<Character>();
		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
//				StringBuilder sb = new StringBuilder();
//				System.out.println("###....start from new end point " + i + ":" + j + "   " + listoString(list));
				list.add(board[i][j]);
				used[i][j] = true;
				boolean flag = backtrack(board, word, list, used, i, j, "&&___");
				if (flag) {
					return true;
				}
				used[i][j] = false;
//				System.out.println("ddd.........." + sb.toString());
//				sb = new StringBuilder(sb.subSequence(0, sb.length() - 1));
				list.remove(list.size()-1);
//				System.out.println(">>>>  ddd.........." + listoString(list));
			}
		}
		return false;
	}

	public boolean backtrack(char[][] board, String word, List<Character> list, boolean[][] used, int a, int b, String print) {
//		System.out.println("..." + a + ":" + b + "   " + sb.toString() + "  " + used[0][1]);
		if (list.size() < word.length()) {
			if (!list.get(list.size()-1).equals(word.charAt(list.size()-1))) {
				return false;
			}
		}
		if (list.size() == word.length()) {
			if (list.get(list.size()-1).equals(word.charAt(list.size()-1))) {
				return true;
			} else {
				return false;
			}
		}
		for (int k = 0; k < d.length; k++) {
//			System.out.println(print + "...........start from new direction " + k + "...." + listoString(list));
			int[] dd = d[k];
			int i = a + dd[0];
			int j = b + dd[1];
//			System.out.println("....d " + dd[0] + ":" + dd[1] + "...ij " + i + ":" + j);
			if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || used[i][j]) {
//				System.out.println(print + "<><>.......ccc " + listoString(list));
				
//				if(print.equals("&&&&&&___") && sb.toString().equals("ABC")){
//					System.out.println("...");
//					System.out.println("...");
//					System.out.println("...");
//					System.out.println("...");
//				}
				continue;
			}

//			sb.append(board[i][j]);
			list.add(board[i][j]);
//			long ss = System.currentTimeMillis();
//			System.out.println(print + ".....》《 " + listoString(list));
					
			used[i][j] = true;
			boolean flag = backtrack(board, word, list, used, i, j, "&&" + print);
			if (flag) {
				return true;
			}
			used[i][j] = false;
//			System.out.println(print + "<<<<.......fff " + listoString(list));
			list.remove(list.size()-1);
//			System.out.println(print + ">>>>.......fff " + listoString(list));

		}
		return false;
	}
	
//	public String listoString(List<Character> list){
//		StringBuilder sb = new StringBuilder();
//		for(Character c : list){
//			sb.append(c);
//		}
//		return sb.toString();
//	}
}
