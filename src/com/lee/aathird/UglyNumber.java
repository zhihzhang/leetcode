package com.lee.aathird;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isUgly(int num) {
		int t = num;
		if(t==0){
			return false;
		}
		while (t != 1) {
			if (t % 5 == 0) {
				t = t / 5;
			} else if (t % 3 == 0) {
				t = t / 3;
			} else if (t % 2 == 0) {
				t = t / 2;
			} else {
				return false;
			}
		}
		return true;
	}

}
