package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DailyTemp739 {

	public static void main(String[] args) {
		DailyTemp739 obj = new DailyTemp739();
		// System.out.println(Arrays.toString(obj.dailyTemperatures(new int[] {
		// 73, 74, 75, 71, 69, 72, 76, 73 })));
		System.out
				.println(Arrays.toString(obj.dailyTemperatures(new int[] { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 })));
	}

	public int[] dailyTemperatures(int[] T) {
		if (T == null || T.length == 0) {
			return new int[] {};
		}
		if (T.length == 1) {
			return new int[] { 0 };
		}
		// List<Integer> list = new ArrayList<>();
		int[] ans = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		stack.push(T.length - 1);
		ans[T.length - 1] = 0;
		for (int i = T.length - 2; i >= 0; i--) {
			if(i==4 || i==5){
				System.out.println("....");
			}
			while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				stack.push(i);
				ans[i] = 0;
				continue;
			}

			System.out.println(i + "...." + stack.peek() + "...." + T[i] + "....." + Arrays.toString(ans) + "..." + stack.toString());
			if (T[i] < T[stack.peek()]) {
				ans[i] = stack.peek() - i;
				stack.push(i);
			}
		}
		return ans;
	}

}
