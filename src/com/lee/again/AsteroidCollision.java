package com.lee.again;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		AsteroidCollision obj = new AsteroidCollision();
		int[] a = new int[] { 1, -2, -2, -2 };
		int[] w = obj.asteroidCollision(a);
		System.out.println(Arrays.toString(w));
	}

	// asteroids = [5, 10, -5]
	// Output: [5, 10]
	//
	// asteroids = [10, 2, -5]
	// Output: [10]
	//
	// asteroids = [-2, -1, 1, 2]
	// Output: [-2, -1, 1, 2]

	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int a : asteroids) {
			if (a > 0) {
				stack.push(a);
			} else if (stack.isEmpty() || stack.peek() < 0) {
				stack.push(a);
			} else {
				while (!stack.isEmpty()) {
					int v = stack.pop();
					if (v < 0) {
						stack.push(v);
						stack.push(a);
						break;
					} else if (v + a == 0) {
						break;
					} else if (v + a > 0) {
						stack.push(v);
						break;
					} else {
						if (stack.isEmpty()) {
							stack.add(a);
							break;
						}
					}
				}
			}
		}
		System.out.println(stack.toString());
		int[] t = new int[stack.size()];
		int i = t.length - 1;
		while (i >= 0) {
			t[i--] = stack.pop();
		}

		return t;
	}

}
