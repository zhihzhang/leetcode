package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction {

	public static void main(String[] args) {
		QueueReconstruction obj = new QueueReconstruction();
		int[][] people = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] a = obj.reconstructQueue(people);
		System.out.println(Arrays.toString(a));
	}

	// Input:
	// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	//
	// Output:
	// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

	// 50 70 52 61 44 71
	//
	// 44 50 52 61 70 71
	// 50 70 61 71 52 44
	// 70 50 71 61 52 44
	
	// 70 71 61 50 52 44

	public int[][] reconstructQueue(int[][] people) {
		List<int[]> list = new ArrayList<>();
		for (int[] p : people) {
			list.add(p);
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o2[0] - o1[0];
				}
			}
		});
		ArrayList<int[]> result = new ArrayList<>();
		for (int[] t : list) {
			result.add(t[1], new int[] { t[0], t[1] });
		}

		int[][] res = new int[people.length][2];
		int i = 0;
		for (int[] k : result) {
			res[i][0] = k[0];
			res[i][1] = k[1];
			i++;
		}

		return res;

	}

}
