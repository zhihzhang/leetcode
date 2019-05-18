package com.lee.again;

public class GameofLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				live(board, i, j);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = board[i][j] / 10;
			}
		}
	}

	public void live(int[][] board, int i, int j) {
		int count = 0;
		int[][] da = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { 1, -1 }, { 1, 1 },
				{ -1, 1 } };
		for (int[] d : da) {
			int a = i + d[0];
			int b = j + d[1];
			if (a >= 0 && a < board.length && b >= 0 && b < board[0].length) {
				if (board[a][b] % 10 == 1) {
					count++;
				}
			}
		}

		if (count == 3) {
			board[i][j] = board[i][j] + 10;
		} else if (count == 2) {
			if (board[i][j] == 1) {
				board[i][j] = board[i][j] + 10;
			}
		}
	}

}
