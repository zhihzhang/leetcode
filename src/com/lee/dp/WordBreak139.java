package com.lee.dp;

import java.util.Arrays;
import java.util.List;


public class WordBreak139 {
	public static void main(String[] args) {
		WordBreak139 obj = new WordBreak139();
		{
			String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
			String[] wordDict = { "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa" };
			boolean f = obj.wordBreak(s,Arrays.asList(wordDict) );
			System.out.println(f);
		}
				
//		String s = "123456";
//		System.out.println(s.substring(0,2));
//		System.out.println(s.substring(2));
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;

		int max = 0;
		for (String t : wordDict) {
			max = Math.max(max, t.length());
		}

		for (int i = 1; i <= s.length(); i++) {
			int t = 0;
			if (i > max) {
				t = i-max;
			}
			for (int j = t; j < i; j++) {
				if (f[j] && wordDict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[s.length()];
	}
	
//    public boolean wordBreak(String s, List<String> wordDict) {
//    	if(s==null || s.isEmpty()){
//    		return false;
//    	}
//    	if(s.length()==1){
//    		return wordDict.contains(s);
//    	}
//    	if(wordDict.contains(s)){
//    		return true;
//    	}
//        int max = 0;
//        for(String t: wordDict){
//            max = Math.max(max, t.length());
//        }
//        
//        if(s.length()<max){
//            max = s.length();
//        }
//        
//		return check(s, wordDict, max);
//    }
//    
//    public boolean check(String s, List<String> wordDict, int max) {
//    	if(wordDict.contains(s)){
//    		return true;
//    	}
//        if(s.length()<max){
//            max = s.length();
//        }
//        
//		for (int i = max; i > 0; i--) {
//			String x = s.substring(0, i);
//			if(wordDict.contains(x)){
//				boolean f =  check(s.substring(i), wordDict, max);
//				if(f){
//					return true;
//				}
//			}
//		}
//		return false;
//    }
	
//    public boolean wordBreak(String s, List<String> wordDict) {
//    	if(s==null || s.isEmpty()){
//    		return false;
//    	}
//    	if(s.length()==1){
//    		return wordDict.contains(s);
//    	}
//    	if(wordDict.contains(s)){
//    		return true;
//    	}
//        int max = 0;
//        for(String t: wordDict){
//            max = Math.max(max, t.length());
//        }
//        
//		for (int i = max; i > 0; i--) {
//			String x = s.substring(0, i);
//			if(wordDict.contains(x)){
//				boolean f =  wordBreak(s.substring(i), wordDict);
//				if(f){
//					return true;
//				}
//			}
//		}
//		return false;
//    }
}
