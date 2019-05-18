package com.lee.again;

import java.util.Arrays;

public class Minesweeper529 {
	public static void main(String[] args) {

	}
	
//	[['E', 'E', 'E', 'E', 'E'],
//	 ['E', 'E', 'M', 'E', 'E'],
//	 ['E', 'E', 'E', 'E', 'E'],
//	 ['E', 'E', 'E', 'E', 'E']]
//
//	Click : [3,0]

	int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
			{ -1, -1 } };

	public char[][] updateBoard(char[][] board, int[] click) {
		// char[][] r = Arrays.copyOf(board, board.length);
		int i = click[0];
		int j = click[1];
		char c = board[i][j];
		if (c == 'M') {
			board[i][j] = 'X';
			return board;
		} else if (c == 'E') {
			int count = 0;
			for (int[] d : directions) {
				int a = i + d[0];
				int b = j + d[1];
				if (a >= 0 && b >= 0 && a < board.length && b < board[0].length) {
					if (board[a][b] == 'M') {
						count++;
					}
				}
			}
			if (count == 0) {
				board[i][j] = 'B';
				for (int[] d : directions) {
					int a = i + d[0];
					int b = j + d[1];
					if (a >= 0 && b >= 0 && a < board.length && b < board[0].length) {
						if (board[a][b] == 'E') {
							board = updateBoard(board, new int[] { a, b });
						}
					}
				}
			} else {
				board[i][j] = (count+"").charAt(0);
			}

		} else if (c == 'B') {
			return board;
		}
		return board;

	}
}
