package com.lee.againt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PreviousPermutationWithOneSwap {

	public static void main(String[] args) {
		PreviousPermutationWithOneSwap obj = new PreviousPermutationWithOneSwap();
		System.out.println(Arrays.toString(obj.prevPermOpt1(new int[]{3,2,1})));
		System.out.println(Arrays.toString(obj.prevPermOpt1(new int[]{1,2,3})));
		System.out.println(Arrays.toString(obj.prevPermOpt1(new int[]{1,1,5})));
		System.out.println(Arrays.toString(obj.prevPermOpt1(new int[]{1,9,4,6,7})));
		System.out.println(Arrays.toString(obj.prevPermOpt1(new int[]{3,1,1,3})));

	}

	public int[] prevPermOpt1(int[] A) {
		List<Integer> list = new ArrayList<>();
		list.add(A[A.length - 1]);
		for (int i = A.length - 2; i >= 0; i--) {
			list.add(A[i]);
			if (A[i] > A[i + 1]) {
				Collections.sort(list);
				int index = list.indexOf(A[i]);
				int v = list.get(index - 1);
				for (int j = i + 1; j < A.length; j++) {
					if (A[j] == v) {
						A[j] = A[i];
						A[i] = v;
						return A;
					}
				}
			}
		}
		return A;
	}

}
