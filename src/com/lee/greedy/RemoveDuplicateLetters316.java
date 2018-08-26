package com.lee.greedy;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetters316 {

	public static void main(String[] args) {
		int[] cnt = new int[26];
		cnt[0]=1;
		System.out.println('b'-'a');
		
		String s = "123456";
		System.out.println(s.substring(4));
			
			
//		String x = "cbacdcbc";
//		x = removeDuplicateLetters(x);
//		System.out.println(x);
	}
	
    public static String removeDuplicateLetters(String s) {
    	Map<Character, Boolean> map = new HashMap<Character, Boolean>();
    	char[] array = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    	if(s==null && s.length()==0){
    		return "";
    	}
    	for(int i=0;i<s.length();i++){
    		map.put(s.charAt(i), true);
    	}
    	StringBuilder sb = new StringBuilder("");
    	for(char c:array){
    		if(map.containsKey(c)){
    			sb.append(c);
    		}
    	}
        return sb.toString();
    }

}
