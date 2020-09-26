package com.lee.aathird;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnesZeroes {

	public static void main(String[] args) {
		OnesZeroes obj = new OnesZeroes();
		System.out.println(obj.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));

	}
	int min = -1;
	Map<String, Integer> map = new HashMap<>();
	Map<String, Integer> zeros = new HashMap<>();
	Map<String, Integer> ones = new HashMap<>();

	public int findMaxForm(String[] strs, int m, int n) {
		for (String s : strs) {
			int a = 0;
			for(char c:s.toCharArray()){
				if(c=='0'){
					a++;
				}
			}
			zeros.put(s, a);
			ones.put(s, s.length()-a);
		}
		List<String> list = new ArrayList<>();
		for(String s: strs){
			list.add(s);
		}
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		int[] visited = new int[list.size()];
		backTrace(list, m, n, 0, visited);
		return min;
	}
	
	public void backTrace(List<String> list, int m, int n, int count, int[] visited){
		if (count > min) {
			min = count;
		}
		for (int i = 0; i < list.size(); i++) {
			if (visited[i] == 1) {
				continue;
			}
			String s = list.get(i);
			int a = zeros.get(s);
			int b = ones.get(s);
			if (a > m || b > n) {
				continue;
			}
			visited[i]=1;
			backTrace(list, m-a, n-b, count+1, visited);
			visited[i]=0;
		}
	
	}

}
