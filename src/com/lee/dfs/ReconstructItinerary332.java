package com.lee.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ReconstructItinerary332 {

	public static void main(String[] args) {
		ReconstructItinerary332 obj = new ReconstructItinerary332();
//		TreeSet<String> s = new TreeSet<>();
		String[][] tickets = new String[][]{
			{"EZE","AXA"},
			{"TIA","ANU"},
			{"ANU","JFK"},
			{"JFK","ANU"},
			{"ANU","EZE"},
			{"TIA","ANU"},
			{"AXA","TIA"},
			{"TIA","JFK"},
			{"ANU","TIA"},
			{"JFK","TIA"} 
		};
		List<String> list = obj.findItinerary(tickets);
		System.out.println(list.toString());
	}
	
    public List<String> findItinerary(String[][] tickets) {
		Map<String, List<String>> map = new HashMap<>();
//		Set<String> numSet = new HashSet<String>();
		for (String[] a : tickets) {
			if (!map.containsKey(a[0])) {
				List<String> s = new ArrayList<>();
				s.add(a[1]);
				map.put(a[0], s);
			} else {
				map.get(a[0]).add(a[1]);
			}
		}
		System.out.println(map.toString());
		
		for(Map.Entry<String, List<String>> entry:map.entrySet()){
			Collections.sort(entry.getValue());
		}

		int num = tickets.length + 1;
		LinkedList<String> list = new LinkedList<>();
		list.add("JFK");
		traverse("JFK", map, list, num);
		return list;
    }
    
    public boolean traverse(String from, Map<String, List<String>> map, LinkedList<String> list, int num){
    	List<String> tList = map.get(from);
		if (tList == null) {
			return false;
		}
//		Set<String> t = new HashSet<>();
//		t.addAll(set);
		for (int i=0;i<tList.size();i++) {
			String s = tList.get(0);
			tList.remove(0);
			list.add(s);
			if (list.size() == num) {
				return true;
			}
			if (traverse(s, map, list, num)) {
				return true;
			} else {
				list.removeLast();
				tList.add(s);
			}
		}
    	return false;
    }
    
    

}
