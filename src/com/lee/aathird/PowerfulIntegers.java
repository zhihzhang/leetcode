package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class PowerfulIntegers {

	public static void main(String[] args) {
		PowerfulIntegers obj = new PowerfulIntegers();
		
		System.out.println(Math.pow(2, 5) );
	}

	// public boolean isPowerOfTwo(int n) {
	// if(n<0){
	// return false;
	// }
	// int t = Integer.bitCount(n);
	// return (t==1);
	// }

//	Input: x = 2, y = 3, bound = 10
//			Output: [2,3,4,5,7,9,10]
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		List<Integer> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (Math.pow(x, i) + Math.pow(y, j) <= bound) {
			int k = (int) (Math.pow(x, i) + Math.pow(y, j));
			if (!list.contains(k)) {
				list.add(k);
			}
			if((Math.pow(x, i+1) + Math.pow(y, j))<(Math.pow(x, i) + Math.pow(y, j+1))){
				i++;
			}else{
				j++;
			}
		}
		return list;
	}

}
