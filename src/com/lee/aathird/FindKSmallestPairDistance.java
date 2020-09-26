package com.lee.aathird;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FindKSmallestPairDistance {

	public static void main(String[] args) {
		FindKSmallestPairDistance obj = new FindKSmallestPairDistance();
		System.out.println(obj.smallestDistancePair(new int[]{1,3,1},2));

	}
	
	public int smallestDistancePair2(int[] nums, int k) {
        int len=nums.length;
        int len2=1000000;
        int[] dp= new int[len2];
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
             int dif= Math.abs(nums[i]-nums[j]);
               dp[dif]++;
            }
        }
        int sum=0;
        for(int i=0;i<len2;i++){
            sum+=dp[i];
            if(sum>=k) return i;
        }
        return 0;
    }
	
	//1,3,1

	public int smallestDistancePair(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		Queue<int[]> queue = new PriorityQueue<>(
				(a, b) -> (Math.abs(nums[a[0]] - nums[a[1]]) - Math.abs(nums[b[0]] - nums[b[1]])));
		Set<String> set = new HashSet<>();
		for (int i = 0; i < nums.length - 1; i++) {
			queue.add(new int[] { i, i + 1 });
		}
		int count = 0;
		while (!queue.isEmpty()) {
			int[] a = queue.poll();
			String key0 = a[0] + ":" + a[1];
			if (!set.contains(key0)) {
				set.add(key0);
				count++;
			}
			if (count == k) {
				return Math.abs(nums[a[0]] - nums[a[1]]);
			}
			if (a[1] < nums.length - 1) {
				queue.add(new int[] { a[0], a[1] + 1 });
			}
		}
		return 0;
	}

}
