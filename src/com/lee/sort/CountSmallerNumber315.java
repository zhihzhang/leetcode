package com.lee.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountSmallerNumber315 {
	static int number = 0;

	public static void main(String[] args) {
		int[] a = { 5,2,6,1 };
		System.out.println("......" + Arrays.toString(a));
		CountSmallerNumber315 obj = new CountSmallerNumber315();
		List list = obj.countSmaller(a);
		System.out.println("......" + Arrays.toString(list.toArray()));
	}

	public List<Integer> countSmaller(int[] nums) {
		int[] index = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			index[i] = i;
		}
		int[] count = new int[nums.length];
		Arrays.fill(count, 0);
		
		sort(nums, 0, nums.length - 1, index, count);
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i : count) {
			list.add(i);
		}
		return list;
	}

	private void sort(int[] a, int left, int right, int[] index, int[] count) {
		if (left >= right) {
			return;
		}

		int mid = (left + right) / 2;
		// 二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
		sort(a, left, mid, index, count);
		sort(a, mid + 1, right, index, count);
		merge(a, left, mid, right, index, count);
	}

	private void merge(int[] a, int left, int mid, int right, int[] index, int[] count) {
		int[] tmp = new int[a.length];
		int[] tmpIndex = new int[a.length];
		int r1 = mid + 1;
		int tIndex = left;
		int cIndex = left;
		// 逐个归并
		int c = 0;
		while (left <= mid && r1 <= right) {
			if (a[left] <= a[r1]) {
				tmpIndex[tIndex] = index[left];
				count[tmpIndex[tIndex]] += c;
				
				tmp[tIndex++] = a[left++];
			} else {
				c++;
				tmpIndex[tIndex] = index[r1];
				
				tmp[tIndex++] = a[r1++];
			}
		}
		// 将左边剩余的归并
		while (left <= mid) {
			tmpIndex[tIndex] = index[left];
			count[tmpIndex[tIndex]] += c;
			
			tmp[tIndex++] = a[left++];
		}
		// 将右边剩余的归并
		while (r1 <= right) {
			tmpIndex[tIndex] = index[r1];
			
			tmp[tIndex++] = a[r1++];
		}

		System.out.println("第" + (++number) + "趟排序:\t");
		// TODO Auto-generated method stub
		// 从临时数组拷贝到原数组
		while (cIndex <= right) {
			a[cIndex] = tmp[cIndex];
			index[cIndex] = tmpIndex[cIndex];
			// 输出中间归并排序结果
//			System.out.print(a[cIndex] + ".....count " + count[cIndex] + "\t");
			cIndex++;
		}
//		System.out.println("-------------------------");
	}
}
