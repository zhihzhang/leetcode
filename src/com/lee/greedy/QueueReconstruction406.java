package com.lee.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction406 {

	public static void main(String[] args) {
		QueueReconstruction406 obj = new QueueReconstruction406();
		int[][] q = new int[][]{
			{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
		};
		obj.reconstructQueue(q);
	}

	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}

		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (b[0] == a[0]){
					return a[1] - b[1];
				}
				return b[0] - a[0];
			}
		});
		
		for(int[] q:people){
			System.out.print(Arrays.toString(q) + "  ");
		}
		System.out.println("   ");
		System.out.println("------222----------");
		
		int n = people.length;
		List<int[]> tmp = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			tmp.add(people[i][1], new int[] { people[i][0], people[i][1] });
			
			
			System.out.println("------OOO----------");
			for(int[] q:tmp){
				System.out.print(Arrays.toString(q) + " ");
			}
			System.out.println(" ");
		}
		
		

		int[][] res = new int[people.length][2];
		int i = 0;
		for (int[] k : tmp) {
			res[i][0] = k[0];
			res[i++][1] = k[1];
		}

		return res;
	}
}
