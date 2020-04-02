package com.lee.againt;

public class SurroundedRegions130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean[][] visited;

	public void solve(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		int x = board.length;
		int y = board[0].length;
		visited = new boolean[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (i == 0 || i == x - 1 || j == 0 || j == y - 1) {
					explore(board, i, j, x, y);
				}
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (!visited[i][j] && board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	public void explore(char[][] board, int i, int j, int x, int y) {
		if (i < 0 || j < 0 || i >= x || j >= y) {
			return;
		}
		if (visited[i][j] || board[i][j] == 'X') {
			return;
		}
		visited[i][j] = true;
		explore(board, i - 1, j, x, y);
		explore(board, i + 1, j, x, y);
		explore(board, i, j - 1, x, y);
		explore(board, i, j + 1, x, y);
	}

}
