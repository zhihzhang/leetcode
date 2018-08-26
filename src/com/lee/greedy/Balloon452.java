package com.lee.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Balloon452 {

	public static void main(String[] args) {
		int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
		int w = findMinArrowShots(points);
		System.out.println(w);
	}
	
	public static int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		} else if (points.length == 1) {
			return 1;
		}
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[0]==b[0]) return a[1]-b[1];
				else return a[0]-b[0];
			}
		});
		int jump = 1;
//		int min = points[0][0];
		int max = points[0][1];
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > max) {
//				min = points[i][0];
				max = points[i][1];
				jump++;
			}
			max = Math.min(max, points[i][1]);
		}
		return jump;
	}
	
//	public static void quickSort(int[][] arr, int low, int high){
//	    if(arr.length <= 0) return;
//	    if(low >= high) return;
//	    int left = low;
//	    int right = high;
//
//	    int temp = arr[left][0];   
//	    while (left < right){
//	        while(left < right && arr[right][0] >= temp){  
//	            right--;
//	        }
//	        arr[left] = arr[right];
//	        while(left < right && arr[left][0] <= temp){  
//	            left++;
//	        }
//	        arr[right] = arr[left];
//	    }
//	    arr[left] = temp;   
//	    quickSort(arr, low, left-1);
//	    quickSort(arr, left+1, high);
//	}

}
