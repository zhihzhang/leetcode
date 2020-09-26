package com.lee.aafour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {

	public static void main(String[] args) {
		ExclusiveTimeFunctions obj = new ExclusiveTimeFunctions();
		String[] t = new String[] { "0:start:0", "1:start:2", "1:end:5", "0:end:6" };
		List<String> logs = new ArrayList<>();
		for (String s : t) {
			logs.add(s);
		}
		int n = 2;
		int[] v = obj.exclusiveTime(n, logs);
		System.out.println(Arrays.toString(v));

	}
	
//	3
//	["0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3"]

	public int[] exclusiveTime(int n, List<String> logs) {
		int[] value = new int[n];
		Stack<Integer> ids = new Stack<>();
		Stack<Integer> timestamps = new Stack<>();
		for (String log : logs) {
			String[] arr = log.split(":");
			int id = Integer.valueOf(arr[0]);
			int ts = Integer.valueOf(arr[2]);
			if (arr[1].equals("start")) {
				if (!ids.isEmpty()) {
					int preId = ids.peek();
					int preTs = timestamps.peek();
					value[preId] = value[preId] + (ts - preTs);
				}
				timestamps.push(ts);
				ids.push(id);
			} else {
				int preId = ids.peek();
				int preTs = timestamps.peek();
				ts = ts + 1;
				value[preId] = value[preId] + (ts - preTs);
				ids.pop();
				timestamps.push(ts);
			}
		}
		return value;
	}

}
