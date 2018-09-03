package com.lee.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloMain {

	public static void main(String[] args) {
		Map<List, Integer> map = new HashMap<List, Integer>();
		List<String> list = new ArrayList();
		list.add("a");
		list.add("a");
		list.add("b");
		map.put(list, 123);
		System.out.println(map.get(list));
		System.out.println(list.size());
		list.remove("a");
		System.out.println(list.size());
		
		System.out.println(Arrays.toString(list.toArray()));
		
		
		
		
		System.out.println(map.get(list));
		
		
		List<String> temp = new ArrayList();
		temp.add("a");
		temp.add("a");
		temp.add("b");
		System.out.println(map.get(temp));
		
		
		System.out.println('a'-0);
	}

}
