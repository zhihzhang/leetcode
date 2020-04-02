package com.lee.againt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	public static void main(String[] args) {
		WordLadder obj = new WordLadder();
		List<String> list = new ArrayList<>();
		list.add("hot");
//		list.add("dot");
		list.add("dog");
//		list.add("lot");
//		list.add("log");
//		list.add("cog");
		int x = obj.ladderLength("hot", "dog", list);
		System.out.println(x);

	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord)){
			return 0;
		}
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		wordList.remove(beginWord);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String a = queue.poll();
				if (a.equals(endWord)) {
					return level;
				}
				List<String> t = new ArrayList<>();
				for (String s : wordList) {
					if (isNeighbor(a, s)) {
						queue.offer(s);
						t.add(s);
					}
				}
				wordList.removeAll(t);
			}
			level++;
		}
		return 0;
	}

	public boolean isNeighbor(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
		}
		if (count == 1) {
			return true;
		}
		return false;
	}

}
