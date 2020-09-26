package com.lee.againt;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		Triangle obj = new Triangle();
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> a = new ArrayList<>();
		a.add(2);
		List<Integer> b = new ArrayList<>();
		b.add(3);
		b.add(4);
		List<Integer> c = new ArrayList<>();
		c.add(6);
		c.add(5);
		c.add(7);
		List<Integer> d = new ArrayList<>();
		d.add(4);
		d.add(1);
		d.add(8);
		d.add(3);
		triangle.add(a);
		triangle.add(b);
		triangle.add(c);
		triangle.add(d);
		System.out.println(obj.minimumTotal(triangle));
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			List<Integer> list = triangle.get(i);
			List<Integer> temp = triangle.get(i+1);
			int l = list.size();
			
			for (int j = 0; j < l; j++) {
				int v = Math.min(temp.get(j), temp.get(j + 1)) + list.get(j);
				list.add(v);
			}
			for (int j = 0; j < l; j++) {
				list.remove(0);
			}
		}
		return triangle.get(0).get(0);
	}

}
