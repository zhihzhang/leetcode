package com.lee.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

	public static void main(String[] args) {
		GroupAnagrams49 obj = new GroupAnagrams49();
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> list = obj.groupAnagrams(strs);
		System.out.println(list.size());

	}
	
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	for(String s:strs){
    		char[] t = s.toCharArray();
    		Arrays.sort(t);
    		StringBuilder sb = new StringBuilder();
    		sb.append(t);
    		String key = sb.toString();
    		if(map.containsKey(key)){
    			List<String> list = map.get(key);
    			list.add(s);
    		}else{
    			List<String> list = new ArrayList<String>();
    			list.add(s);
    			map.put(key, list);
    		}
    	}
    	
    	List<List<String>> r = new ArrayList<List<String>>();
    	r.addAll(map.values());
    	return r;
        
    }

}
