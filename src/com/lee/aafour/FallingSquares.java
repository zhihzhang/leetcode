package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FallingSquares {

	public static void main(String[] args) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(5, 1);
		map.put(10, 1);
		map.put(15, 1);
		System.out.println(map.floorKey(3));
		System.out.println(map.floorKey(7));

		System.out.println(map.ceilingKey(13));
		System.out.println(map.ceilingKey(17));

	}

	public List<Integer> fallingSquares(int[][] positions) {
		return null;
		
//		List<Integer> result = new ArrayList<>();
//		TreeMap<Integer, int[]> map = new TreeMap<>();
//		map.put(-2, new int[] { 1, 1, 1 });
//		int currentHeight = 0;
//		for (int[] p : positions) {
//			int l = p[0];
//			int r = p[0] + p[1];
//			int h = p[1];
//
//			Integer pre = map.floorKey(l);
//			List<Integer> list = new ArrayList<>();
//			list.addAll(map.keySet());
//			int idx = 0;
//			if (pre != null) {
//				idx = list.indexOf(pre);
//			}
//
//			for (int i = idx; i < list.size(); i++) {
//				if (i == 0) {
//					continue;
//				}
//				int k = list.get(i);
//				int[] v = map.get(k);
//				int start = v[0];
//				int end = v[1];
//				int height = v[2];
//
//				if (end < l) {
//					continue;
//				} else if (r<start){
//					;
//				} else if(){
//					
//				}
//			}
//
//		}
	}

}
