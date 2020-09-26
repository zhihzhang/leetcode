package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;

public class ArrayNesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	Input: A = [5,4,0,3,1,6,2]
//	Output: 4
//	Explanation: 
//	A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
//
//	One of the longest S[K]:
//	S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
	public int arrayNesting(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				continue;
			}
			if(nums[i]==i){
				max = Math.max(max, 1);
				continue;
			}
			List<Integer> list = new ArrayList<>();
			int j = i;
			while (true) {
				if (nums[j] < 0) {
					max = Math.max(max, list.size() - list.indexOf(-nums[j]));
					break;
				}
				int t = nums[j];
				list.add(t);
				nums[j] = -t;
				j = t;
			}
		}
		return max;
	}

}
