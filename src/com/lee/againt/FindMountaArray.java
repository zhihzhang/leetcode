package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMountaArray {
	// [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82]
	// 81

	public static void main(String[] args) {
		Map<String, Map> map = new HashMap<>();
		map.put("123", null);
		FindMountaArray obj = new FindMountaArray();
		 int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
				 42, 43, 44, 45, 46, 47, 48, 49, 50,
				 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67,
				 68, 69, 70, 71, 72, 73, 74, 75, 76,
				 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93,
				 94, 95, 96, 97, 98, 99, 100, 101,
		 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84,
		 83, 82 };

//		 int[] array = new int[] { 3, 5, 3, 2, 0 };
//		int[] array = new int[] { 0, 5, 3, 1 };
		List<Integer> list = new ArrayList<>();
		for (int n : array) {
			list.add(n);
		}

		MountainArray mountainArr = new MountainArray(list);
		System.out.println(obj.findInMountainArray(97, mountainArr));

	}


	public int findInMountainArray(int target, MountainArray arr) {
		int l = 0;
		int r = arr.length() - 1;
		int peak = 0;
		while (l < r) {
			int m = (l + r) / 2;
			if (arr.get(m) < arr.get(m + 1)) {
				peak = m + 1;
				l = m + 1;
			} else {
				r = m;
			}
		}
		int idx = findIncreasing(target, arr, 0, peak);
		if (idx != -1) {
			return idx;
		}
		return findDescreasing(target, arr, peak, arr.length() - 1);
		
	}

	public int findDescreasing(int target, MountainArray arr, int l, int r) {
		if (l > r) {
			return -1;
		}
		int m = (l + r) / 2;
		int mv = arr.get(m);
		if (mv == target) {
			return m;
		} else if (mv > target) {
			return findDescreasing(target, arr, m + 1, r);
		} else {
			return findDescreasing(target, arr, l, m - 1);
		}
	}

	public int findIncreasing(int target, MountainArray arr, int l, int r) {
		if (l > r) {
			return -1;
		}
		int m = (l + r) / 2;
		int mv = arr.get(m);
		if (mv == target) {
			return m;
		} else if (mv < target) {
			return findIncreasing(target, arr, m + 1, r);
		} else {
			return findIncreasing(target, arr, l, m - 1);
		}
	}
}

class MountainArray {
	List<Integer> list;

	public MountainArray(List<Integer> list) {
		this.list = list;
	}

	public int get(int index) {
		return list.get(index);
	}

	public int length() {
		return list.size();
	}
}
