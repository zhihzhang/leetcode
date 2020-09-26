package com.lee.aafour;

import java.util.HashMap;
import java.util.Map;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String p = "a*2?b";
//		System.out.println(p.indexOf("*?"));
//		p = p.replaceAll("\\*\\?", "*");
//		System.out.println(p);
		WildcardMatching obj = new WildcardMatching();
		System.out.println(obj.isMatch("aa", "a"));
		System.out.println(obj.isMatch("aa", "*"));
		System.out.println(obj.isMatch("cb", "?a"));
		System.out.println(obj.isMatch("adceb", "*a*b"));
		System.out.println(obj.isMatch("acdcb", "a*c?b"));
		System.out.println(obj.isMatch("ab", "?*"));
		System.out.println(obj.isMatch("ab", "a*"));
		System.out.println(obj.isMatch("", "*"));
		System.out.println(obj.isMatch("aab", "c*a*b"));
	}
	
	
//	"aab", "c*a*b"
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0]=true;
		for (int j = 1; j <= p.length(); j++) {
			if (p.charAt(j - 1) != '*') {
				break;
			}
			dp[0][j] = true;
		}
		for(int i=1;i<=s.length();i++){
			for(int j=1;j<=p.length();j++){
				if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
					dp[i][j] = dp[i-1][j-1];
				} else if (p.charAt(j-1)=='*'){
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	
//	Map<String, Boolean> cache = new HashMap<>();
//	
//	public String getKey(String s, String p){
//		return s+"::"+p;
//	}
//
//	public boolean isMatch(String s, String p) {
//		while(p.indexOf("**")>-1){
//			p = p.replaceAll("\\*\\*", "*");
//		}
//		if(cache.containsKey(getKey(s, p))){
//			return cache.get(getKey(s, p));
//		}
//		
//		int i = 0;
//		while (i < p.length() && i<s.length()) {
//			char a = s.charAt(i);
//			char c = p.charAt(i);
//			if (a == c || c=='?') {
//				i++;
//				continue;
//			}
//			if (a != c && c != '*') {
//				cache.put(getKey(s, p), false);
//				return false;
//			}
//			// *
//			if (i == p.length()-1) {
//				cache.put(getKey(s, p), true);
//				return true;
//			}
//			char k = p.charAt(i+1);
//			for (int j = i; j < s.length(); j++) {
//				if (k == s.charAt(j) || k=='?') {
//					boolean r = isMatch(s.substring(j), p.substring(i+1));
//					if (r) {
//						cache.put(getKey(s, p), true);
//						return true;
//					}
//				}
//			}
//			return false;
//		}
//		if(s.length()==p.length()){
//			cache.put(getKey(s, p), true);
//			return true;
//		}
//		if(p.length()>s.length() && p.substring(s.length()).equals("*")){
//			cache.put(getKey(s, p), true);
//			return true;
//		}
//		cache.put(getKey(s, p), false);
//		return false;
//	}

}
