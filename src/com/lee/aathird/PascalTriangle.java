package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//    [1],
//   [1,1],
//  [1,2,1],
// [1,3,3,1],
//[1,4,6,4,1]

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> a = new ArrayList<>();
			if (i < 2) {
				for (int j = 0; j <= i; j++) {
					a.add(1);
				}
				list.add(a);
			} else {
				List<Integer> b = list.get(list.size() - 1);
				a.add(1);
				for (int j = 0; j < b.size()-1; j++) {
					a.add(b.get(j) + b.get(j + 1));
				}
				a.add(1);
				list.add(a);
			}
		}
		return list;
	}

}
