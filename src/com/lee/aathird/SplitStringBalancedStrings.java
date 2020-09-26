package com.lee.aathird;

public class SplitStringBalancedStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	Input: s = "RLRRLLRLRL"
//			Output: 4
//			Input: s = "RLLLLRRRLR"
//			Output: 3
//			Input: s = "LLLLRRRR"
//			Output: 1
//			Input: s = "RLRRRLLRLL"
//			Output: 2
	public int balancedStringSplit(String s) {
		int n = 0;
		int count = 0;
		char[] arr = s.toCharArray();
		char pre = ' ';
		for (int i = 0; i < arr.length; i++) {
			if (count == 0) {
				pre = arr[i];
				count++;
			} else if (pre == arr[i]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					n++;
					pre = ' ';
				}
			}
		}
		return n;
	}

}
