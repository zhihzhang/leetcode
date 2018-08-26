package com.lee.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class letterCombinations17 {

	public static void main(String[] args) {
		letterCombinations("23");
//		StringBuilder sb = new StringBuilder();
//		sb.append("123");
//		sb.deleteCharAt(sb.length()-1);
//		System.out.println(sb.toString());

	}
	
	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if(digits.isEmpty()) return list;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		int[] nums = new int[digits.length()];
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			nums[i]=x;
		}
		System.out.println(nums[0] + "," + nums[1]);
		backtrack(list, new StringBuilder(), mapping, nums, 0, digits.length());
		return list;
	}
	
	public static void backtrack(List<String> list , StringBuilder tempList, String[] mapping, int[] nums, int start, int size){
//		System.out.println("...start..." + start);
		if(tempList.length()==size){
			System.out.println("...temp " + tempList.toString());
			list.add(tempList.toString());
			return;
		}
	    for(char c:mapping[nums[start]].toCharArray()){
	    	tempList.append(c);
			backtrack(list, tempList, mapping, nums, start+1, size);
			tempList.deleteCharAt(tempList.length()-1);
	    }
	}

}
