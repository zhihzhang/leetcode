package com.lee.again;

import java.util.ArrayList;
import java.util.List;

public class CandyCrush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] candyCrush(int[][] board) {
		boolean flag = false;
		do {
			flag = candy(board);
		} while (flag);
		return board;
	}

	public boolean candy(int[][] board) {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			int a = 0;
			int b = 0;
			while (board[i][a] == board[i][b] && b < board[0].length) {
				b++;
			}
			if (b == board[0].length) {
				b = b - 1;
			}
			if (b - a > 1) {
				for (int k = a; k <= b; k++) {
					list.add(new int[] { i, k });
				}
			}
			a = b;
			if(board[i][b]==0 || b+2>=board[0].length){
				break;
			}
		}

		for (int j = 0; j < board[0].length; j++) {
			;
		}
		return !list.isEmpty();
	}

}
