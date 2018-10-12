package com.lee.hashmap;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxPoints149 {

	public static void main(String[] args) {
		MaxPoints149 obj = new MaxPoints149();
		Point p;
		
		Point[] array = new Point[21];
		array[0] = new Point(0,9);
		array[1] = new Point(138,429);
		array[2] = new Point(115,359);
		array[3] = new Point(115,359);
		array[4] = new Point(-30,-102);
		array[5] = new Point(230,709);
		array[6] = new Point(-150,-686);
		array[7] = new Point(-135,-613);
		array[8] = new Point(-60,-248);
		array[9] = new Point(-161,-481);
		array[10] = new Point(207,639);
		array[11] = new Point(23,79);
		array[12] = new Point(-230,-691);
		array[13] = new Point(-115,-341);
		
		array[14] = new Point(92,289);
		array[15] = new Point(60,336);
		array[16] = new Point(-105,-467);
		array[17] = new Point(135,701);
		array[18] = new Point(-90,-394);
		array[19] = new Point(-184,-551);
		array[20] = new Point(150,774);
		
		int x = obj.maxPoints(array);
		System.out.println("...result " + x);
		
//		[[0,9],[138,429],[115,359],[115,359],[-30,-102],[230,709],[-150,-686],[-135,-613],
//		 [-60,-248],[-161,-481],[207,639],[23,79],[-230,-691],[-115,-341],
//		 [92,289],[60,336],[-105,-467],[135,701],[-90,-394],[-184,-551],[150,774]]
		
//		230,709

	}

	public int maxPoints(Point[] points) {
		if (points.length <= 0) {
			return 0;
		}
		if (points.length <= 2) {
			return points.length;
		}
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			Map<java.math.BigDecimal , Integer> map = new HashMap<java.math.BigDecimal , Integer>();
			int sameX = 1;
			int samePosition = 0;
			for (int j = 0; j < points.length; j++) {
				if (i == j) { // ignore the same one
					continue;
				}
				if ((points[j].x == points[i].x) && (points[j].y == points[i].y)) { // same										// position
					samePosition++;
					continue;
				}
				if (points[j].x == points[i].x) {
					sameX++;
					continue;
				}
				
				java.math.BigDecimal a = null;
				java.math.BigDecimal b = null;
				java.math.BigDecimal k = null;
				
				if (points[j].x > points[i].x) {
					a = new java.math.BigDecimal(points[j].y - points[i].y);
					b = new java.math.BigDecimal(points[j].x - points[i].x);
					k = a.divide(b, 20, java.math.RoundingMode.HALF_UP);
				} else {
					a = new java.math.BigDecimal(points[i].y - points[j].y);
					b = new java.math.BigDecimal(points[i].x - points[j].x);
					k = a.divide(b, 20, java.math.RoundingMode.HALF_UP);
				}
				

				
				if (map.containsKey(k)) {
					map.put(k, map.get(k) + 1);
				} else {
					map.put(k, 2);
				}
				max = Math.max(max, map.get(k) + samePosition);
				if (i == 5) {
					System.out.println("...k=" + k + "...c=" + map.get(k) + "...x=" + points[j].x + "...y=" + points[j].y); 
				}
			}
			max = Math.max(max, sameX);
		}
		return max;
	}


}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
