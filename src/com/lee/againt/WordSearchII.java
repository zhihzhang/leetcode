package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {

	public static void main(String[] args) {
		WordSearchII obj = new WordSearchII();
		char[][] board = new char[][]{
			{'o','a','a','n'},
			{'e','t','a','e'},
			{'i','h','k','r'},
			{'i','f','l','v'}
		};
		String[] words = new String[]{"oath","pea","eat","rain"};
		System.out.println(obj.findWords(board, words).toString());

	}

	public List<String> findWords(char[][] board, String[] words) {
		Map<Character, List<String>> map = new HashMap<>();
		for(String s:words){
			char c = s.charAt(0);
			if(!map.containsKey(c)){
				map.put(c, new ArrayList<String>());
			}
			map.get(c).add(s);
		}
		List<String> list = new ArrayList<>();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				List<String> wList = map.get(board[i][j]);
				if(wList==null){
					continue;
				}
				for(String s:words){
					if(list.contains(s)){
						continue;
					}
					if(explore(board, new boolean[board.length][board[0].length] , i, j, s, 0)){
						list.add(s);
					}
				}
			}
		}
		return list;

	}

	public boolean explore(char[][] board, boolean[][] visited, int i, int j, String w, int index) {
		if (board[i][j] == w.charAt(index)) {
			if (index == w.length() - 1) {
				return true;
			}
			visited[i][j] = true;
			if (i - 1 >= 0 && visited[i - 1][j] == false) {
				if(explore(board, visited, i - 1, j, w, index + 1)){
					return true;
				}
			}
			if (j - 1 >= 0 && visited[i][j - 1] == false) {
				if(explore(board, visited, i, j - 1, w, index + 1)){
					return true;
				}
			}
			if (i + 1 < board.length && visited[i + 1][j] == false) {
				if(explore(board, visited, i + 1, j, w, index + 1)){
					return true;
				}
			}
			if (j + 1 < board[0].length && visited[i][j + 1] == false) {
				if(explore(board, visited, i, j + 1, w, index + 1)){
					return true;
				}
			}
			visited[i][j] = false;
		}

		return false;
	}

}
