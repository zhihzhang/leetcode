package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		WordBreak obj = new WordBreak();
		String s = "applepenapple";
		String[] words = new String[]{"apple", "pen1"};
		List<String> wordDict = new ArrayList<>();
		for(String w:words){
			wordDict.add(w);
		}
		System.out.println(obj.wordBreak(s, wordDict));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			String t = s.substring(0, i);
			for (String w : wordDict) {
				if (t.endsWith(w) && dp[i - w.length()]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
