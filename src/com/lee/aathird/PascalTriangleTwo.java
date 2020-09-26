package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleTwo {

	public static void main(String[] args) {
		PascalTriangleTwo obj = new PascalTriangleTwo();
		System.out.println(obj.getRow(3));

	}

	// [1],
	// [1,1],
	// [1,2,1],
	// [1,3,3,1],
	// [1,4,6,4,1]
	// [1,5,10,10,5,1]
	// [1,6,15,20,15,6,1]
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		if (rowIndex == 0) {
			list.add(1);
			return list;
		}
		if (rowIndex == 1) {
			list.add(1);
			list.add(1);
			return list;
		}
		list.add(1);
		list.add(1);
		for (int i = 2; i < rowIndex+1; i++) {
			List<Integer> a = new ArrayList<>();
			a.add(1);
			for (int j = 0; j < list.size() - 1; j++) {
				a.add(list.get(j) + list.get(j + 1));
			}
			a.add(1);
			list = a;
		}
		return list;
	}

}
