package com.lee.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanPartitionK698 {

	public static void main(String[] args) {
		CanPartitionK698 obj = new CanPartitionK698();

		{
			int[] nums = new int[] { 3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871,
					269 };
			boolean result = obj.canPartitionKSubsets(nums, 5);
			System.out.println(result);
		}

		// {
		// int[] nums = new int[] { 4, 15, 1, 1, 1, 1, 3, 11, 1, 10 };
		// boolean result = obj.canPartitionKSubsets(nums, 3);
		// System.out.println(result);
		// }
		//
		// {
		// int[] nums = new int[] { 4, 3, 2, 3, 5, 2, 1 };
		// boolean result = obj.canPartitionKSubsets(nums, 4);
		// System.out.println(result);
		// }
		//
		// {
		// int[] nums = new int[] { 2, 2, 2, 2, 3, 4, 5 };
		// boolean result = obj.canPartitionKSubsets(nums, 4);
		// System.out.println(result);
		// }
	}

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

		if (list.isEmpty() || list.get(0) > target) {
			return false;
		}

		List<Long> rList = new ArrayList<Long>();
		while (true) {
			boolean flag = search(list, target, 0, rList);
			if (flag) {
				for (Long l : rList) {
					list.remove(l);
				}
				rList.clear();
			} else {
				return false;
			}
			k--;
			if (list.isEmpty() && k == 0) {
				return true;
			}
			if ((k == 0 && !list.isEmpty()) || (list.isEmpty() && k > 0)) {
				return false;
			}
		}
	}

	public boolean search(List<Long> list, long target, int startIndex, List<Long> rList) {
		for (int i = startIndex; i < list.size(); i++) {
			long temp = list.get(i);
			if (temp == target) {
				rList.add(temp);
				return true;
			}
			if (temp > target) {
				continue;
			}
			if (temp < target) {
				rList.add(temp);
				boolean f = search(list, target - temp, i + 1, rList);
				if (f) {
					return f;
				} else {
					rList.remove(temp);
				}
			}
		}

		return false;
	}

}
