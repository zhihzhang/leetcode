package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings obj = new IsomorphicStrings();
		System.out.println(obj.isIsomorphic("abbbc", "gttwd"));

	}

	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		
		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		
		List<Integer> sList = new ArrayList<>();
		List<Integer> tList = new ArrayList<>();
		
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(!sMap.containsKey(c)){
				sMap.put(c, i);
				sList.add(i);
			}else{
				sList.add(sMap.get(c));
			}
		}
		
		for(int i=0;i<t.length();i++){
			char c = t.charAt(i);
			if(!tMap.containsKey(c)){
				tMap.put(c, i);
				tList.add(i);
			}else{
				tList.add(tMap.get(c));
			}
		}
		
		return sList.toString().equals(tList.toString());

	}

}
