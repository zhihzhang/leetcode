package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {

	public static void main(String[] args) {
		FindDuplicateFileinSystem obj = new FindDuplicateFileinSystem();
		String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		System.out.println(obj.findDuplicate(paths));

	}
	
//	Input:
//		["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
//		Output:  
//		[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
//	
    public List<List<String>> findDuplicate(String[] paths) {
    	List<List<String>> result = new ArrayList<>();
    	Map<String, List<String>> map = new HashMap<>();
    	for(String s:paths){
			String[] arr = s.split(" ");
			String root = arr[0];
			for (int i = 1; i < arr.length; i++) {
				String[] t = arr[i].split("\\(");
				String file = t[0];
				String format = t[1].substring(0, t[1].length()-1);
				if(!map.containsKey(format)){
					map.put(format, new ArrayList<>());
				}
				map.get(format).add(root + "/" + file);
			}
    	}
		for (List<String> list : map.values()) {
			if (list.size() > 1) {
				result.add(list);
			}
		}
        return result;
    }

}
