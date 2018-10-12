package com.lee.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CanPartitionKSubsets698 {

	public static void main(String[] args) {
		CanPartitionKSubsets698 obj = new CanPartitionKSubsets698();

		{
			int[] nums = new int[] { 3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871,
					269 };
			boolean result = obj.canPartitionKSubsets(nums, 5);
			System.out.println(result);
		}

//		{
//			int[] nums = new int[] { 4, 15, 1, 1, 1, 1, 3, 11, 1, 10 };
//			boolean result = obj.canPartitionKSubsets(nums, 3);
//			System.out.println(result);
//		}
//
//		{
//			int[] nums = new int[] { 4, 3, 2, 3, 5, 2, 1 };
//			boolean result = obj.canPartitionKSubsets(nums, 4);
//			System.out.println(result);
//		}
//
//		{
//			int[] nums = new int[] { 2, 2, 2, 2, 3, 4, 5 };
//			boolean result = obj.canPartitionKSubsets(nums, 4);
//			System.out.println(result);
//		}
	}

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	Map<String, Boolean> flagMap = new HashMap<String, Boolean>();

	public boolean canPartitionKSubsets(int[] nums, int k) {
		long sum = 0;

		List<Long> list = new ArrayList<Long>();
		for (int i : nums) {
			sum += i;
			list.add((long) i);
		}
		Collections.sort(list);
		Collections.reverse(list);

		if (sum % k != 0) {
			return false;
		}
		if (nums.length < k) {
			return false;
		}

		long target = sum / k;

		return canP(list, k, target);
	}

	public boolean canP(List<Long> list, int k, long target) {
		if (k == 0) {
			return true;
		}

		if (list.isEmpty() && k > 0) {
			return false;
		}

		long sum = 0;

		List<Long> removeList = new ArrayList<Long>();

		for (int i = 0; i < list.size(); i++) {
			if (list.contains(target - sum)) {
				
//				List<Long> newList = new ArrayList<Long>(list);
//				newList.remove(target - sum);
//				for (long value : removeList) {
//					newList.remove(value);
//				}
				
				list.remove(target - sum);
				for (long value : removeList) {
					list.remove(value);
				}
				return canP(list, k - 1, target);
//				if (f) {
//					return true;
//				} else {
//					continue;
//				}
			}
			long temp = list.get(i);
			System.out.println(sum + "..." + temp);

			if (sum + temp < target) {
				// list.remove(temp);
				removeList.add(temp);
				sum = sum + temp;
				continue;
			}
			
//			if(sum + temp > target){
//				;
//			}

			// no sum+temp=target suitation
			// if sum+temp>target continue;

		}

		return false;
	}

}
