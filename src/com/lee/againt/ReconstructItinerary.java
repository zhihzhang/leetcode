package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {
	public static void main(String[] args) {
		ReconstructItinerary obj = new ReconstructItinerary();
		String[][] t = new String[][]{
			{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}
		};
		List<List<String>> tickets = new ArrayList<>();
		for(String[] x:t){
			List<String> l = new ArrayList<>();
			l.add(x[0]);
			l.add(x[1]);
			tickets.add(l);
		}
		System.out.println(obj.findItinerary(tickets).toString());
	}


	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, Queue<String>> map = new HashMap<>();
		for (List<String> trip : tickets) {
			if (!map.containsKey(trip.get(0))) {
				map.put(trip.get(0), new PriorityQueue<String>());
			}
			map.get(trip.get(0)).add(trip.get(1));
		}
		int size = tickets.size() + 1;
		List<String> list = new ArrayList<>();
		list.add("JFK");
		explore(map, size, list, "JFK");
		return list;
	}

	public void explore(Map<String, Queue<String>> map, int size, List<String> list, String s) {
		Queue<String> queue = map.get(s);
		if (queue == null) {
			return;
		}
		List<String> temp = new ArrayList<>();
		temp.addAll(queue);
		for (String t : temp) {
			queue.remove(t);
			list.add(t);
			explore(map, size, list, t);
			if (list.size() == size) {
				return;
			}
			//Critical
			list.remove(list.size()-1);
			queue.add(t);
		}

	}

}
