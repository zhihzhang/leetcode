package com.lee.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

	public static void main(String[] args) {
		DailyTemperatures739 obj = new DailyTemperatures739();
		int[] dt = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
		int[] ans = obj.dailyTemperatures(dt);
		System.out.println(Arrays.toString(ans));
	}
	
	public int[] dailyTemperatures(int[] T) {
		int[] ans = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = T.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
				stack.pop();
			}
			ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return ans;
	}
}
