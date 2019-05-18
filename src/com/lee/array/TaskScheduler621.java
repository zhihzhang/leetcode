package com.lee.array;

import java.util.Arrays;

public class TaskScheduler621 {

	public static void main(String[] args) {
		TaskScheduler621 obj = new TaskScheduler621();
		char[] tasks = new char[]{'A','A','A','B','B','B'};
		int n = 2;
		System.out.println(obj.leastInterval(tasks, n));
	}
	
	public int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c : tasks) {
			map[c - 'A']++;
		}
		Arrays.sort(map);
		int max_val = map[25] - 1;
		int idle_slots = max_val * n;
		int t = max_val * (n+1);
		System.out.println(".......t " + t);
		int count = 1;
		for (int i = 24; i >= 0 && map[i] > 0; i--) {
			idle_slots -= Math.min(map[i], max_val);
			if(map[i]>max_val){
				count +=map[i]-max_val;
			}
		}
		System.out.println("......count " + count);
		return idle_slots > 0 ? t + count : tasks.length;
	}

	
//	public int leastInterval(char[] tasks, int n) {
//		int[] map = new int[26];
//		for (char c : tasks) {
//			map[c - 'A']++;
//		}
//		Arrays.sort(map);
//		int max_val = map[25] - 1;
//		int idle_slots = max_val * n;
//		for (int i = 24; i >= 0 && map[i] > 0; i--) {
//			idle_slots -= Math.min(map[i], max_val);
//		}
//		return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
//	}

//	public int leastInterval(char[] tasks, int n) {
//		int[] map = new int[26];
//		for (char c : tasks) {
//			map[c - 'A']++;
//		}
//		Arrays.sort(map);
//		int count = tasks.length + 1;
//		while(count>0){
//			int t = 25;
//			for(int i=0;i<n;i++){
//				
//				count--;
//			}
//		}
//	}

}
