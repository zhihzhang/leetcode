package com.lee.array;

import java.util.Map;
import java.util.TreeMap;

public class CalendarOne729 {

	public static void main(String[] args) {
		CalendarOne729 obj = new CalendarOne729();
//		System.out.println(obj.book(10, 25));
//		System.out.println(obj.book(45, 75));
//		System.out.println(obj.book(30, 75));
//		System.out.println(obj.book(75, 80));
//		System.out.println(obj.book(5, 15));
//		System.out.println(obj.book(5, 10));
		
//		["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
//				[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
		
		System.out.println(obj.book(47,50));
		System.out.println(obj.book(33,41));
		System.out.println(obj.book(39,45));
		System.out.println(obj.book(33,42));
		System.out.println(obj.book(25,32));
		System.out.println(obj.book(26,35));
		System.out.println(obj.book(19,25));
		System.out.println(obj.book(3,8));
		System.out.println(obj.book(0,5));
//		System.out.println(obj.book(8,13));
//		System.out.println(obj.book(18,27));
	}

	Map<Integer, Integer> cal = new TreeMap<Integer, Integer>();

	public CalendarOne729() {

	}

	public boolean book(int start, int end) {
		if (cal.isEmpty()) {
			cal.put(start, end);
			return true;
		}
		Object[] array = cal.keySet().toArray();
		int index = this.bSearch(array, 0, array.length - 1, start);
		
		System.out.println(index);
//		if (index < 0) {
//			cal.put(start, end);
//			return true;
//		}
		if (index > -1 && (int) array[index] == start) {
			return false;
		}
		
//		if ((int) array[index] > start) {
//			;
//		}
		
		if (index < 0) {
			index = 0;
		}
		
		for (int i = index; i < array.length; i++) {
			int startValue = (int) array[i];
			
			if (startValue < start) {
				if (cal.get(array[i]) > start) {
					return false;
				}
			} else if (startValue == start) {
				return false;
			} else {
				if (startValue >= end) {
					cal.put(start, end);
					return true;
				}
				return false;
			}
//			if (startValue >= end) {
//				cal.put(start, end);
//				return true;
//			}
//			
//			int endValue = cal.get(array[i]);
//			if (endValue > start) {
//				return false;
//			}
		}
		cal.put(start, end);
		return true;
	}

	public int bSearch(Object[] array, int startIndex, int endIndex, int start) {
		if (startIndex >= endIndex) {
			return endIndex;
		}
		int mid = (startIndex + endIndex) / 2;
		if ((int) array[mid] > start) {
			return this.bSearch(array, 0, mid - 1, start);
		} else if ((int) array[mid] == start) {
			return mid;
		} else {
			if (mid == array.length - 1 || (int) array[mid + 1] > start) {
				return mid;
			}
			return this.bSearch(array, mid + 1, endIndex, start);
		}
	}

}
